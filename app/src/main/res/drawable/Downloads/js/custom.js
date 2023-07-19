// JavaScript Document

$(function() {

 "use strict";



  function responsive_dropdown () {

    /* ---- For Mobile Menu Dropdown JS Start ---- */

      $('#menu span.opener').on("click", function() {

        if ($(this).hasClass("plus")) {

          $(this).parent().find('.mobile-sub-menu').slideDown();

          $(this).removeClass('plus');

          $(this).addClass('minus');

        }

        else

        {

          $(this).parent().find('.mobile-sub-menu').slideUp();

          $(this).removeClass('minus');

          $(this).addClass('plus');

        }

        return false;

      });

    /* ---- For Mobile Menu Dropdown JS End ---- */



    /*---Mobile menu icon Start---*/

      var navbar_toggle = $('.navbar-toggle i');

      var menu_var = $('#menu');

      $('.navbar-toggle').on("click", function(){

        

        if(menu_var.hasClass('menu-open')){

          menu_var.removeClass('menu-open');

          navbar_toggle.removeClass('fa-close');

          navbar_toggle.addClass('fa-bars');

        }else{

          menu_var.addClass('menu-open');

          navbar_toggle.addClass('fa-close');

          navbar_toggle.removeClass('fa-bars');

        }

        return false;

      });

    /*---Mobile menu icon End---*/

    

    /* ---- For Sidebar JS Start ---- */

      $('.sidebar-box span.opener').on("click", function(){

      

        if ($(this).hasClass("plus")) {

          $(this).parent().find('.sidebar-contant').slideDown();

          $(this).removeClass('plus');

          $(this).addClass('minus');

        }

        else

        {

          $(this).parent().find('.sidebar-contant').slideUp();

          $(this).removeClass('minus');

          $(this).addClass('plus');

        }

        return false;

      });

    /* ---- For Sidebar JS End ---- */

    /* ---- For Footer JS Start ---- */

      $('.footer-static-block span.opener').on("click", function(){

      

        if ($(this).hasClass("plus")) {

          $(this).parent().find('.footer-block-contant').slideDown();

          $(this).removeClass('plus');

          $(this).addClass('minus');

        }

        else

        {

          $(this).parent().find('.footer-block-contant').slideUp();

          $(this).removeClass('minus');

          $(this).addClass('plus');

        }

        return false;

      });

    /* ---- For Footer JS End ---- */

  }



  function owlcarousel_slider () {

    /* ------------ OWL Slider Start  ------------- */

      /* ----- pro_cat_slider Start  ------ */

      $('.pro_cat_slider').owlCarousel({

        items: 4,

        navigation: true,

        pagination: false,

        itemsDesktop : [1199, 4],

        itemsDesktopSmall : [991, 3],

        itemsTablet : [768, 2],

        itemsTabletSmall : false,

        itemsMobile : [479, 1]

      });

      /* ----- pro_cat_slider End  ------ */

      /* ----- brand-logo Start  ------ */

      $('#brand-logo').owlCarousel({

        items: 4,

        navigation: true,

        pagination: false,

        itemsDesktop : [1199, 3],

        itemsDesktopSmall : [991, 3],

        itemsTablet : [768, 2],

        itemsTabletSmall : false,

        itemsMobile : [479, 1]

      });

      /* ----- brand-logo End  ------ */

      /* ---- Testimonial Start ---- */

      $("#client, .main-banner").owlCarousel({

     

       /* navigation : true,  Show next and prev buttons*/

        slideSpeed : 300,

        paginationSpeed : 400,

        autoPlay: false,

        pagination:true,

        singleItem:true,

        navigation:true



      });

      /* ----- Testimonial End  ------ */

    /* ------------ OWL Slider End  ------------- */

  }



  function scrolltop_arrow () {

   /* ---- Page Scrollup JS Start ---- */

   //When distance from top = 250px fade button in/out

    var scrollup = $('#scrollup');

    var headertag = $('header');

    var mainfix = $('.main');

    $(window).scroll(function(){

      if ($(this).scrollTop() > 250) {

          scrollup.fadeIn(300);

      } else {

          scrollup.fadeOut(300);

      }



      /* header-fixed JS Start */

      if ($(this).scrollTop() > 100){

         headertag.addClass("header-fixed");

      }

      else{ 

         headertag.removeClass("header-fixed");

      }



      /* main-fixed JS Start */

      if ($(this).scrollTop() > 0){

         mainfix.addClass("main-fixed");

      }

      else{ 

         mainfix.removeClass("main-fixed");

      }

      /* ---- Page Scrollup JS End ---- */

    });

    

    //On click scroll to top of page t = 1000ms

    scrollup.on("click", function(){

        $("html, body").animate({ scrollTop: 0 }, 1000);

        return false;

    });

  }



  

  function custom_tab() {

   /* ----------- product category Tab Start  ------------ */

    $('.tab-stap').on('click', 'li', function() {

        $('.tab-stap li').removeClass('active');

        $(this).addClass('active');

        

        $(".product-slider-main").fadeOut();

        var currentLiID = $(this).attr('id');

        $("#data-"+currentLiID).fadeIn();

        return false;

    });

    /* ------------ product category Tab End  ------------ */

    /* ------------ Account Tab JS Start ------------ */

    $('.account-tab-stap').on('click', 'li', function() {

        $('.account-tab-stap li').removeClass('active');

        $(this).addClass('active');

        

        $(".account-content").fadeOut();

        var currentLiID = $(this).attr('id');

        $("#data-"+currentLiID).fadeIn();

        return false;

    });

    /* ------------ Account Tab JS End ------------ */

  }



  /* Price-range Js Start */

  function price_range () {

      $( "#slider-range" ).slider({

      range: true,

      min: 0,

      max: 800,

      values: [ 75, 500 ],

      slide: function( event, ui ) {

      $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );

      }

      });

      $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +

      " - $" + $( "#slider-range" ).slider( "values", 1 ) );

  }

  /* Price-range Js End */



  /* Product Detail Page Tab JS Start */

  function description_tab () {

    $("#tabs li a").on("click", function(e){

      var title = $(e.currentTarget).attr("title");

      $("#tabs li a").removeClass("selected")

      $(".tab_content li div").removeClass("selected")

      $(".tab-"+title).addClass("selected")

      $(".items-"+title).addClass("selected")

      $("#items").attr("class","tab-"+title);



      return false;

    });

  }

  /* Product Detail Page Tab JS End */



   /*Load-More Js Start*/

  function load_more () {

    $(".best-pro-col").slice(0, 8).show();

    $("#loadMore-best").on('click', function (e) {

        e.preventDefault();

        $(".best-pro-col:hidden").slice(0, 4).slideDown();

        if ($(".best-pro-col:hidden").length == 0) {

            $("#load").fadeOut('slow');

        }

    });



    $(".new-pro-col").slice(0, 8).show();

    $("#loadMore-new").on('click', function (e) {

        e.preventDefault();

        $(".new-pro-col:hidden").slice(0, 4).slideDown();

        if ($(".new-pro-col:hidden").length == 0) {

            $("#load").fadeOut('slow');

        }

    });



    $(".special-pro-col").slice(0, 8).show();

    $("#loadMore-special").on('click', function (e) {

        e.preventDefault();

        $(".special-pro-col:hidden").slice(0, 4).slideDown();

        if ($(".special-pro-col:hidden").length == 0) {

            $("#load").fadeOut('slow');

        }

    });

  }



  /*Load-More Js Ends*/



  /*Select Menu Js Start*/

  function option_drop() {

  $( "#country" ).selectmenu();

  $( "#currency" ).selectmenu();

  };

  /*Select Menu Js Ends*/



  $(document).ready(function() {

    owlcarousel_slider(); price_range (); responsive_dropdown(); description_tab (); custom_tab (); scrolltop_arrow (); load_more(); option_drop();

  });



});



  $( window ).on( "load", function() {

    // Animate loader off screen

    $(".se-pre-con").fadeOut("slow");

    //Disable Right Mouse Click/keyboard Start
    
    $(function() {
      $(this).bind("contextmenu", function(e) {
          e.preventDefault();
      });
      document.onkeydown = function (e) {
          return false;
      }
    });
    
    //Disable Right Mouse Click/keyboard End

  });

