<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕하세요 서브웨이입니다 ~ </title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&family=Roboto+Condensed:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body {
            margin : 0px;
            padding : 0px;
            color:blanchedalmond;
        }

        #img{
            display: none;
            position: absolute;
            top : 250px;
            left : 1100px;
        }

        #title{
			margin-top:40px;
            text-align:center; 
            font-size:45px;
        }

        #title1{
            color: #ffce32;
        }

        #title2{
            color: #009223;
        }

        #header {
            background-color: white; 
            padding-bottom: 10px;
            line-height:100px
        }

        #btn-zone{
            text-align:right; 
            padding-right: 20px;
        }

        .wrap{
            width : 820px;
            height : 830px;
            margin : auto;
        }

        .content{
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: bold;
            background-color: #009222;
            border-radius: 20px;
        }

        table {
            border-collapse: separate;
            border-spacing: 0 5px;
        }

        input[type=checkbox]{
            margin-right: 10px;
            margin-left : 5px;
        }

        th, legend{
            padding-left: 20px;
        }

        a {
            text-decoration: none;
            color: crimson;
        }

    </style>
</head>
<body>
    <div class="wrap">
    
        <div id="header">
            <h1 id="title">
                <span id="title1">SUB</span><span id="title2">WAY</span>
            </h1>
        </div>
        
       
        <div class="content">
            <br><br>
            <form action="order.do" method="get">

                <fieldset>
                    <legend>주문자 정보</legend>

                    <table>
                        <tr>
                            <th width="130">이름</th>
                            <td><input type="text" name="userName" class="form-control" required></td>
                        </tr>
                        <tr>
                            <th>전화번호</th>
                            <td><input type="text" name="phone" class="form-control" required></td>
                        </tr>
                        <tr>
                            <th>주소</th>
                            <td><input type="text" name="address" class="form-control" required></td>
                        </tr>
                        <tr>
                            <th>요청사항</th>
                            <td><textarea name="message" cols="80" rows="5" class="form-control" style="resize:none"></textarea></td>
                        </tr>
                    </table>
                </fieldset>

                <br>

                <fieldset>
                    <legend>주문 정보</legend>

                    <table>
                        <tr>
                            <th width="130">샌드위치</th>
                            <td>
                                <select name="sandwich" class="form-control">
                                    <option>스파이시 바비큐</option>
                                    <option>스파이시 쉬림프</option>
                                    <option>스테이크 & 치즈</option>
                                    <option>로티세리 바비큐 치킨</option>
                                    <option>K-바비큐</option>
                                    <option>풀드 포크 바비큐</option>
                                    <option>머쉬룸</option>
                                    <option>쉬림프</option>
                                    <option>로스트 치킨</option>
                                    <option>치킨 데리야끼</option>
                                    <option>서브웨이 클럽</option>
                                    <option>치킨 슬라이스</option>
                                    <option>참치</option>
                                    <option>에그마요</option>
                                    <option>이탈리안 비엠티</option>
                                    <option>터키 베이컨 아보카도</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>채소</th>
                            <td>
                                <input type="checkbox" name="vegetable" value="오이" checked><label>오이</label>
                                <input type="checkbox" name="vegetable" value="양배추" checked>양배추
                                <input type="checkbox" name="vegetable" value="올리브" checked>올리브
                                <input type="checkbox" name="vegetable" value="할라피뇨" checked>할라피뇨
                                <input type="checkbox" name="vegetable" value="적양파" checked>적양파
                                <input type="checkbox" name="vegetable" value="피망" checked>피망
                                <input type="checkbox" name="vegetable" value="토마토" checked>토마토
                            </td>
                        </tr>
                        <tr>
                            <th>소스</th>
                            <td>
                                <input type="checkbox" name="sauce" value="랜치">랜치
                                <input type="checkbox" name="sauce" value="후추">후추
                                <input type="checkbox" name="sauce" value="스위트 어니언">스위트 어니언
                                <input type="checkbox" name="sauce" value="스위트 칠리">스위트 칠리
                                <input type="checkbox" name="sauce" value="핫칠리">핫 칠리
                                <input type="checkbox" name="sauce" value="마요네즈">마요네즈
                                <input type="checkbox" name="sauce" value="홀스래디쉬">홀스래디쉬
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="checkbox" name="sauce" value="스모크 바비큐">스모크 바비큐
                                <input type="checkbox" name="sauce" value="허니 머스타드">허니 머스타드
                                <input type="checkbox" name="sauce" value="사우스웨스트 치폴레">사우스웨스트 치폴레
                                <input type="checkbox" name="sauce" value="이탈리안 드레싱">이탈리안 드레싱
                            </td>
                        </tr>
                        <tr>
                            <th>쿠키</th>
                            <td>
                                <input type="checkbox" name="cookie" value="라즈베리치즈케잌">라즈베리치즈케잌
                                <input type="checkbox" name="cookie" value="더블초코칩쿠키">더블초코칩쿠키
                                <input type="checkbox" name="cookie" value="스모어초코어쩌고">스모어초코어쩌고
                            </td>
                        </tr>
                        <tr>
                            <th>결제방식</th>
                            <td>
                                <input type="radio" name="payment" value="card" checked> 카드결제
                                <input type="radio" name="payment" value="cash"> 현금결제
                            </td>
                        </tr>
                    </table>	
                </fieldset>

                <br>
                <hr>
                <div id="btn-zone">
                    <input type="submit" class="btn btn-info" value="주문하기">
                    <input type="reset" class="btn btn-warning" value="초기화">
                </div>

            </form>
            <br>
        </div>
        <br>
    </div>
	<a href='orderList.sandwich?value=value'>주문내역보기</a>

    <br>

    <div id="img">
        <img id="sandimg" src="">
    </div>

    <script>
        var timeOut;

        $(() => {
            $('select').change(function() {

	    if(timeOut != undefined){
	        clearTimeout(timeOut);
                }

                const sand = $(this).val();

                sandwich = {
                    '스파이시 바비큐' : 'https://www.subway.co.kr/upload/menu/%EC%8A%A4%ED%8C%8C%EC%9D%B4%EC%8B%9C%EB%B0%94%EB%B9%84%ED%81%90_%EC%A0%95%EB%A9%B4_20221031041334845.png',
                    '스파이시 쉬림프' : 'https://www.subway.co.kr/upload/menu/Spicy_Shrimp_front_20230703125534663.png',
                    '스테이크 & 치즈' : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
                    '스파이시 이탈리안' : 'https://www.subway.co.kr/upload/menu/spicy_italian_20211231095435532.png',
                    '로티세리 바비큐 치킨' : 'https://www.subway.co.kr/upload/menu/Rotisserie-Barbecue-Chicken_20211231023137878.png',
                    '스파이시 바비큐' : 'https://www.subway.co.kr/upload/menu/%EC%8A%A4%ED%8C%8C%EC%9D%B4%EC%8B%9C%EB%B0%94%EB%B9%84%ED%81%90_%EC%A0%95%EB%A9%B4_20221031041334845.png',
                    'K-바비큐' : 'https://www.subway.co.kr/upload/menu/K-BBQ_20211231094930225.png',
                    '풀드 포크 바비큐' : 'https://www.subway.co.kr/upload/menu/Pulled-Pork+cheese_20211231095012512.png',
                    '머쉬룸' : 'https://www.subway.co.kr/upload/menu/%EB%A8%B8%EC%89%AC%EB%A3%B8_%EC%83%8C%EB%93%9C%EC%9C%84%EC%B9%98_20220715112921467.png',
                    '쉬림프' : 'https://www.subway.co.kr/upload/menu/Shrimp_20211231095411189.png',
                    '로스트 치킨' : 'https://www.subway.co.kr/upload/menu/Roasted-Chicken_20211231095032718.png',
                    '치킨 데리야끼' : 'https://www.subway.co.kr/upload/menu/Chicken-Teriyaki_20211231094803381.png',
                    '서브웨이 클럽' : 'https://www.subway.co.kr/upload/menu/Subway-Club%E2%84%A2_20211231095518589.png',
                    '치킨 슬라이스' : 'https://www.subway.co.kr/upload/menu/%EC%B9%98%ED%82%A8%EC%8A%AC%EB%9D%BC%EC%9D%B4%EC%8A%A4%EC%83%8C%EB%93%9C%EC%9C%84%EC%B9%98_20220804012537491.png',
                    '참치' : 'https://www.subway.co.kr/upload/menu/Tuna_20211231095535268.png',
                    '에그마요' : 'https://www.subway.co.kr/upload/menu/Egg-Mayo_20211231094817112.png',
                    '이탈리안 비엠티' : 'https://www.subway.co.kr/upload/menu/Italian_B.M.T_20211231094910899.png',
                    '터키 베이컨 아보카도' : 'https://www.subway.co.kr/upload/menu/%EC%B9%98%ED%82%A8%EB%B2%A0%EC%9D%B4%EC%BB%A8%EC%95%84%EB%B3%B4%EC%B9%B4%EB%8F%84%EC%83%8C%EB%93%9C%EC%9C%84%EC%B9%98_20220804012954461.png'
                };

	  
                $.each(sandwich, (k, v) => {
                    if(sand == k){
                        $('#sandimg').attr('src', sandwich[k]);
                    }
                });




                $('#img').show(1000);
                timeOut = setTimeout(() => {
                    $('#img').hide(1000);
                }, 4000);

            });
        });
    </script>



	 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>