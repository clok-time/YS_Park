/**
 * Park_jQuery.js
 */

function connectSearchAddressEvent() {
	$("#join_p_addr1, #join_p_addr2").click(function() {
		new daum.Postcode({
			oncomplete : function(data) {
				$("#join_p_addr1").val(data.zonecode);
				$("#join_p_addr2").val(data.roadAddress);
			}
		}).open();
	});
}

/*
 * REST API 키 35e2b5e13cd830999ab4c5988effa8b4 JavaScript 키
 * f075c32b9d8b09d5bd05fc4a27c54b69
 */
function connectSNSWriteAreaSummonEvent() {
	var swaVisible = false;
	$("#snsWriteAreaSummoner").click(function() {
		if (swaVisible) {
			$("#snsWriteArea").css("left", "-375px");
		} else {
			$("#snsWriteArea").css("left", "0px");
		}
		swaVisible = !swaVisible;
	});
}

function movieRank() {
	$('#mBtn')
			.click(
					function() {
						$('#rankTbl').empty();
						// alert('나마스테');
						let iVal = $('#movieInput').val();
						// 20eb8696cfd020c0839fdd387af2b9ff
						$
								.ajax({

									url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
									data : {
										key : "20eb8696cfd020c0839fdd387af2b9ff",
										targetDt : iVal
									},

									success : function(movie) {
										//alert(JSON.stringify(movie));
										$('#rankTbl').css('opacity', '1');
										// $('#rankTbl').empty();
										var boxOfficeList = movie.boxOfficeResult.dailyBoxOfficeList;
										let th1 = $('<th></th>').text('날짜');
										let thiVal = $('<th></th>').text(iVal);
										let tr1 = $('<tr></tr>').append(th1,
												thiVal);

										let th2 = $('<th></th>').text('순위');
										let th3 = $('<th></th>').text('영화명');
										let tr2 = $('<tr></tr>').append(th2,
												th3);
										$('#rankTbl').append(tr1, tr2);
										$
												.each(
														boxOfficeList,
														function(i, mm) {

															let td2 = $(
																	'<td></td>')
																	.text(
																			mm.rank);
															let td3 = $(
																	'<td onclick="return movieSearch();"></td>')
																	.text(
																			mm.movieNm)
																	.attr(
																			'value',
																			mm.movieCd);
															let tr3 = $(
																	'<tr></tr>')
																	.append(
																			td2,
																			td3);
															$('#rankTbl')
																	.append(tr3);

														});
									}
								});
					});
}

function movieSearch(mCd) {
	var alertCheck = true;

	$(document)
			.on(
					'click',
					'#rankTbl td',
					function() {
						var tdVal = $(this).attr('value');
						//alert(tdVal);
						$
								.ajax({
									url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json",
									data : {
										key : "20eb8696cfd020c0839fdd387af2b9ff",
										movieCd : tdVal
									},
									success : function(movie) {
										// alert(JSON.stringify(movie));
										// alert('실패');
										var movieInfo = movie.movieInfoResult.movieInfo;
										
										// alert(movieList.genreAlt);
										var message = '영화명: '
												+ movieInfo.movieNm
												+ '\r\n'
												+ '장르: '
												+ movieInfo.genres[0].genreNm
												+ '\r\n'
												+ '개봉일: '
												+ movieInfo.openDt
												+ '\r\n'
												+ '감독: '
												+ movieInfo.directors[0].peopleNm;

										if (alertCheck) {

											alert(message);
										}
										alertCheck = false;

									}
								});
					})
}

$(function() {
	connectSearchAddressEvent();
	connectSNSWriteAreaSummonEvent();
	movieRank();
	movieSearch(movieCd);
});
