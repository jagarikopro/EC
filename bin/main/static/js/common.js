
function nav(){
    $.ajax({
        url: "http://localhost:8080/checkuser",
        method: "GET",
        success: function (data) {
            if (data) {
                $(".logincheck").prepend('<a class="nav-link" href="/logout" aria-disabled="true">ログアウト</a>');
                $(".cartcheck").prepend('<a class="nav-link" href="/cart" aria-disabled="true">カート</a>');
                $(".cartcount").prepend('<a class="nav-cart">' + data + '</a>');
            } else {
                $(".logincheck").prepend('<a class="nav-link" href="/login">ログイン</a>');
            }
        },
        error: function (err) {
        }
    });
}
window.onload = nav;

function changeCount() {
    $.ajax({
        url: "http://localhost:8080/cart/changeCount",
        method: "GET",
        success: function (data) {
            if (data) {
                $(".nav-cart").remove();
                $(".cartcount").prepend('<a class="nav-cart">' + data + '</a>');
            }
        },
        error: function (err) {
        }
    });
};