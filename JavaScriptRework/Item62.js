
// [Summary] jQuery 스크롤 사용하기, 스크롤바 만들기 (2022-06-17 01:46:16) 
   

$(document).ready(function() { //<body onload="">

    //1. 태그 동적 추가하기
    $('<div id="scroll-bar-indicator"></div>')
    .css({
        width : 0,
        height: '5px',
        backgroundColor: 'cornflowerblue',
        position: 'fixed',
        left: 0,
        top: 0,
        border: '0px',
        padding: 0,
        margin: 0
    })
    .prependTo($('body'));


    //2. 이벤트 등록하기
    $(document).scroll(function(){

        //문서의 길이(스크롤바의 최대 위치): 100% = 스크롤바 위치 : ?%
        let x = $(document).scrollTop() * 100 / ($(document).outerHeight() - $(window).outerHeight());
        
        $('#scroll-bar-indicator').css('width', x + '%');

    });
});