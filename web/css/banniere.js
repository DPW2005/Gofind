let slideIndex = 1 ;
showSlides(slideIndex) ;
autoSlide()

//Fontion pour afficher la slide suivante
function plusSlides(n){
    showSlides(slideIndex += n) ;
}

//Fonction pour afficher la slide courrante
/*function currentSlide(n){
    showSlides(slideIndex = n) ;
}*/
//Fonction pour afficher n'importe quel slide
function showSlides(n) {
    //Tableau de tous les element de class slides
    let slide = document.getElementsByClassName('banner-slide') ;

    //Tableau de tous les element de class dot
    //let dots = document.getElementsByClassName('dot') ;

    //Initialiser la slide suivante la slide a la premiere
    if(n > slide.length){slideIndex = 1 }

    //Initialiser la slide precedant la premiere a la derniere
    if( n < 1){slideIndex = slide.length }

    //Cacher toutes les slides
    for(let i = 0 ; i < slide.length ; i++){
        slide[i].style.display = "none" ;
    }
    
    //Desactiver toutes les surbrillances
    /*for(let i = 0 ; i < dots.length ; i++){
        dots[i].classList.remove('active') ;
    }*/
    
    //Afficher la slide demander
    slide[slideIndex - 1].style.display = 'block' ;
    slide[slideIndex - 1].style.transition = 'all 1.5s ease-in-out' ;

    //dots[slideIndex - 1].classList.add('active') ;
}

function autoSlide() {
    plusSlides(1) ;
    setTimeout(autoSlide,7000) ;
}



