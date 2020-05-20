$(function(){    
var Product = Backbone.Model.extend({
    default: {
        productId:'',
        name: 'defaultName',
        description:'defaultName',
        price: '100',
        image: 'NoImage',
        cartNum: '1'
    }
});
var Products = Backbone.Collection.extend({
    model: Product,
    url: 'http://localhost:8080/home/get',
    parse: function (res) {
        return res;
    }
});
var SearchProducts = Backbone.Collection.extend({
    model: Product,
    url: 'http://localhost:8080/home/searchget',
    parse: function (res) {
        return res;
    }
});

var ProductView = Backbone.View.extend({
    tagName: 'div',
    className: 'product',
    template: _.template($('#product-template').html()),
    render: function(){
        var template = this.template(this.model.toJSON());
        this.$el.html(template);
        return this;
    },
    events:{
        "click": "details",
        "click .cart-in": "cartIn",
        "click .modal-close": "close"
    },
    details:function(){
        if (event.target.className != "productImage"){
            $(event.target.firstElementChild).fadeIn();
        } else {
            $(event.target.previousElementSibling).fadeIn();
        }
    },
    close:function(){
        $('.product-modal').fadeOut();
        return false;
    },
    cartIn:function(){
        var productCount = event.target.nextElementSibling.value;
        if (productCount < 1){
            alert("数量は[1]以上を入力してください")
            return false;
        }
        this.model.attributes.cartNum = productCount;
        $.ajax({
            url: "http://localhost:8080/home/json",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(this.model.attributes),
            dataType: "json"
        }).done(function (respons, textStatus, jqXHR) {
            switch (respons) {
                case 'OK':
                    changeCount();
                    $('.product-modal').fadeOut();
                    break;
                case 'NO':
                    alert("在庫不足のためカートに追加できません。");
                    break;
                case 'NG':
                    alert("ログインまたは会員登録をしてください。数秒後ログインページへ以降します");
                    setTimeout(function () {
                        location.pathname = '/login';
                    }, 3000);
                    break;
                default:
                    return false;
            }
            if(respons){
                $('.product-modal').fadeOut();
                return false;

            }else{
                alert("在庫不足のためカートに追加できません。")
                // $(".product_details").prepend('<div id="pleaseLogin" class="alert alert-success" role="alert">'+
                //     'ログインまたは会員登録をしてください。数秒後ログインページへ以降します</div>');
                // setTimeout(function () {
                //     location.pathname = '/login';
                // }, 3000)
            }
            // $("#p1").text(jqXHR.status); //例：200
            // $('.msg').text(JSON.stringify(respons))
            // $("#p2").text(JSON.stringify(respons));
        }).fail(function (jqXHR, textStatus, errorThrown) {
            // $("#p1").text(jqXHR.status); //例：404
        }).always(function () {
        });
        return false;
    }
});

    var SlideView = Backbone.View.extend({
        tagName: 'div',
        template: _.template('<% if(image != null){ %> <img src = "../../images/<%- image %>" alt="">'+
                             '<% } else { %><img src="../../images/no_image.png" class="productImage"><% }%>'),
        render: function () {
            var template = this.template(this.model.toJSON());
            this.$el.html(template);
            return this;
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

var SlidesView = Backbone.View.extend({
    tagName: 'div',
    className: 'center',
    render: function () {
        this.collection.each(function (product) {
            var slideView = new SlideView({ model: product });
            this.$el.append(slideView.render().el);
        }, this);
        return this;
    }
});

var likeSerch = $('#likeSerch').val();
if (likeSerch){
    var products = new SearchProducts([]);
        products.fetch({
            data: (likeSerch),
            dataType: "json",
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            success: function success(collection, res, options) {
                if (collection.length == 0){
                    $('#products').prepend('<a>商品がありませんでした。</a>')
                }else{
                    var productsView = new ProductsView({ collection: collection })
                    $('#products').html(productsView.render().el);
                    $('.productList').pagination({
                        itemElement: '> .product',
                        paginationClassName: 'pagination',
                        paginationInnerClassName: 'clearfix',
                        pageNumberClassName: 'page-link',
                        displayItemCount: '9'
                    });
                }
            }
        })
}else{
    var products = new Products([]);
    products.fetch({
        success: function success(collection, res, options) {
            var slidesView = new SlidesView({ collection: collection });
            $('#products').html(slidesView.render().el);
            var productsView = new ProductsView({ collection: collection });
            $('#products').append('<h3 calss="title1">商品一覧</h3>');
            $('#products').append(productsView.render().el);
            $('.productList').pagination({
                itemElement: '> .product',
                paginationClassName: 'pagination',
                paginationInnerClassName: 'clearfix',
                pageNumberClassName: 'page-link',
                displayItemCount: '9'
            });
            $('.center').slick({
                infinite: true, //スライドのループ有効化
                dots: true, //ドットのナビゲーションを表示
                centerMode: true, //要素を中央寄せ
                centerPadding: '10%', //両サイドの見えている部分のサイズ
                autoplay: true, //自動再生
                adaptiveHeight: true
            });
        }
    })
}

    // $('.productList').pagination({
    //     itemElement: '> .product', // アイテムの要素
    //     paginationClassName: 'pagination',
    //     paginationInnerClassName: 'clearfix',
    //     displayItemCount: '2'
    // });
// var productsView = new ProductsView({collection : products})

// });
// const View = Backbone.View.extend({
//     el: '#app',
//     events: {
//         'click button': function () {
//             if (confirm('are you OK?')) {
//                 $.ajax({
//                     url: "http://localhost:8080/home/json",
//                     type: "POST",
//                     contentType: "application/json; charset=utf-8",
//                     // data: JSON.stringify(json),
//                     data: JSON.stringify({ product_id: "1", name: "商品名1" }),
//                     dataType: "json"
//                 }).done(function (data1, textStatus, jqXHR) {
//                     // $("#p1").text(jqXHR.status); //例：200
//                     $('.msg').text(JSON.stringify(data1))
//                     // $("#p2").text(JSON.stringify(data1));
//                 }).fail(function (jqXHR, textStatus, errorThrown) {
//                     // $("#p1").text(jqXHR.status); //例：404
//                 }).always(function () {
//                 });
//             }
//             // this.$el.find('.msg').text('Hello')
//         }
//     }
// })
// new View()

// var Product =  Backbone.Model.extend({
//     defaults: {
//         name: 'タイトルです',
//         completed: false
//     }
// });
// var Products = Backbone.Collection.extend({
//     // model: Product
//     url: 'http://localhost:8080/home/get',
//     parse: function (res) {
//         return res;
//     }
// });

// var ProductView = Backbone.View.extend({
//     tagName: 'li',
//     initialize: function(){
//         this.model.on('destroy', this.remove, this);
//     },
//     events:{
//         'click .delete': 'destroy'
//     },
//     destroy: function(){
//         if(confirm('are you OK?')){
//             this.model.destroy();
//         }
//     },
//     remove: function(){
//         this.$el.remove();
//     },
//     template: _.template($('#product-template').html()),
//     render: function(){
//         var template = this.template(this.model.toJSON());
//         this.$el.html(template);
//         return this;
//     }
// });
// var ProductsView = Backbone.View.extend({
//     tagName: 'ul',
//     render: function(){
//         this.collection.each(function (product) {
//             var productView = new ProductView({model: product});
//             this.$el.append(productView.render().el);
//         },this);
//         return this;
//     }
// });


// var products = new Products([
//     // String(getProducts())
// ]);
// products.fetch({
//     success: function success(collection, res, options) {
//         console.log(collection);
//         // collection.trigger('onFetch');    // 追記：イベント発火
//         // userCollection.trigger('onFetch');  // これでもok
//     }

// });
// var productsView = new ProductsView({collection : products});
// $('#products').html(productsView.render().el);

// // new View()
});