$(function(){

//カート一覧

var Product = Backbone.Model.extend({
    default: {
        productId:'',
        name: 'defaultName',
        description:'defaultName',
        price: '100',
        image: 'NoImage',
        unit: 'yen',
        cartNum: '0',
        defaultCartNum: '0'
    }
});

var Products = Backbone.Collection.extend({
    model: Product,
    url: 'http://localhost:8080/cart/get',
    parse: function (res) {
        return res;
    }
});

var ProductView = Backbone.View.extend({
    tagName: 'div',
    className: 'cart',
    template: _.template($('#cart-template').html()),
    render: function(){
        var template = this.template(this.model.toJSON());
        this.$el.html(template);
        return this;
    },
    events:{
        "click": "details",
        "click .modal-close": "close",
        "click .cart_change": "change",
        "click .cart_delete": "delete"
    },
    details:function(){
        if (event.target.className != "cartInProductImage"){
            $(event.target.firstElementChild).fadeIn();
        } else {
            $(event.target.previousElementSibling).fadeIn();
        }
    },
    close:function(){
        $('.cart-modal').fadeOut();
        return false;
    },
    change: function () {
        var productCount = event.target.previousElementSibling.value;
        var defaultProductCount = event.target.previousElementSibling.defaultValue;
        if (productCount < 1) {
            alert("数量は[1]以上を入力してください")
            return false;
        }
        if (productCount == defaultProductCount){
            alert("数量が変更されていません")
            return false;
        }
        this.model.attributes.cartNum = productCount;
        this.model.attributes.defaultCartNum = defaultProductCount;
        $.ajax({
            url: "http://localhost:8080/cart/change",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(this.model.attributes),
            dataType: "json"
        }).done(function (respons, textStatus, jqXHR) {
            if (respons) {
                window.location.href = "/cart";
                // return false;
            } else {
                alert("在庫不足のため数量を変更できません");
                // return false;
            }
        }).fail(function (jqXHR, textStatus, errorThrown) {
            // $("#p1").text(jqXHR.status); //例：404
        }).always(function () {
            return false;
        });
        return false;
    },
    delete: function () {
        if (window.confirm(this.model.attributes.name +'をカートから削除しますか？')) {
            $.ajax({
                url: "http://localhost:8080/cart/delete",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(this.model.attributes),
                dataType: "json"
            }).done(function (respons, textStatus, jqXHR) {
                if (respons) {
                    window.location.href = "/cart";
                    return false;
                } else {
                  alert("削除に失敗しました");
                  return false;
                }
            }).fail(function (jqXHR, textStatus, errorThrown) {
                // $("#p1").text(jqXHR.status); //例：404
            }).always(function () {
            });
            return false;
        }
        else {
            return false;
        }
    }
});
var ProductsView = Backbone.View.extend({
    tagName: 'ul',
    className: 'productList',
    render: function(){
        this.collection.each(function(product){
            var productView = new ProductView({model: product});
            this.$el.append(productView.render().el);
        },this);
        return this;
    }
});

var products = new Products([]);
products.fetch({
    success: function success(collection, res, options) {
        var productsView = new ProductsView({ collection: collection })
        $('#carts').html(productsView.render().el);
    }
})


//カート合計金額
var TotalPriceditail = Backbone.Model.extend({
    default: {
        totalPrice: ''
    }
});

var TotalPriceditails = Backbone.Collection.extend({
    model: TotalPriceditail,
    url: 'http://localhost:8080/cart/getPrice',
    parse: function (res) {
        return res;
    }
});

var TotalPriceditailView = Backbone.View.extend({
    tagName: 'div',
    className: 'totalprice',
    template: _.template($('#price-template').html() + 
    '<% if(totalPrice != null){ %>'+
        '<form action="/order" method="POST">' +
        '<script src="https://checkout.stripe.com/checkout.js"' +
        'class="stripe-button"' +
        'data-key="pk_test_sO8HLbbU0cthDAYRbG9CWZuD000SSgurSm"' +
        'data-description="購入・支払い"' +
        'data-amount="<%- totalPrice %>"' +
        'data-currency="jpy">' +
        '</script>' +
        '</form>'+
    '<% } %>'),
    render: function () {
        var template = this.template(this.model.toJSON());
        this.$el.html(template);
        return this;
    },
    events: {
        "click #order": "order"
    },
    order: function () {
        window.location.href = "/order";
        return false;
    }
});

    // var Strip = Backbone.View.extend({
    //     tagName: 'div',
    //     template: _.template(
    //         '<form action="#" th:action="@{"/pay"}" method="POST">'+
    //         '<script src="https://checkout.stripe.com/checkout.js"' +
    //         'class="stripe-button"' +
    //         'data-key="pk_test_sO8HLbbU0cthDAYRbG9CWZuD000SSgurSm"' +
    //         'data-description="購入・支払い"' +
    //         'data-amount="<% -totalPrice %>"' +
    //         'data-currency="jpy">' +
    //         '</script>' +
    //         '</form>'),
    //     // template: _.template("<% -totalPrice %>"),
    //     render: function () {
    //         var template = this.template(this.model.toJSON());
    //         this.$el.html(template);
    //         return this;
    //     }
    // });


var TotalPriceditailsView = Backbone.View.extend({
    tagName: 'ul',
    className: 'pricelist',
    render: function () {
        this.collection.each(function (totalPriceditail) {
            var totalPriceditailView = new TotalPriceditailView({ model: totalPriceditail });
            this.$el.append(totalPriceditailView.render().el);
            // var strip = new Strip({ model: totalPriceditail});
            // this.$el.append(strip.render().el);
        }, this);
        return this;
    }
});

var totalPriceditails = new TotalPriceditails([]);
    totalPriceditails.fetch({
    success: function success(collection, res, options) {
        var totalPriceditailsView = new TotalPriceditailsView({ collection: collection })
        $('#totalPrice').html(totalPriceditailsView.render().el);
            $("#stipe").load("checkout");
    }
})


});