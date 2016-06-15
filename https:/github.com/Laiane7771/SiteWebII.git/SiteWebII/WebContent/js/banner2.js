

var banners = ["Image/banner1.jpg", "Image/banner-notebook.jpg", "Image/banner-hp_notebook.jpg"];
var bannerAtual = 0;

function trocaBanner() {
  bannerAtual = (bannerAtual + 1) % 3;
  document.querySelector('#banner_principal').style.backgroundImage = "url("+banners[bannerAtual]+")";
}

setInterval(trocaBanner, 4000);

