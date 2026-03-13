## 26년 3월 13일 수업입니다.

<hr>

<h3>validate등도 배웠지만 숙지하지 못해서 따로 공부 할 예정입니다.</h3>
<h3>게시판 만들기 연습프로젝트 진행했습니다.</h3>

<h4>총 진행</h4>
	작업명	페이지명	요청주소	요청방식	컨트롤러 메소드명	컨트롤러 명	리다이렉트	
1	메인 화면	index.jsp	/, /index	GET	root()			V
								V
2	목록 화면	show.jsp	/show	GET	showPage()			V
	목록 화면 처리			POST				V
3	상세보기 화면	view.jsp	/view	GET	viewPage()			-
	상세보기 화면 처리			POST				-
4	게시글 등록화면	write.jsp	/writepage	POST	writePage()			-
	게시글 등록화면 처리		/write	POST	write()			-
5	회원가입 화면	signup.jsp	/sgupage	GET	signupPage()			V
	회원가입 화면 처리		/signup	POST	signup()			V
6	로그인 화면	login.jsp	/lgpage	GET	loginPage()			V
	로그인 화면 처리		/login	POST	login()			V
6	마이페이지	mypage.jsp	/mypage	GET?인가	myPage()		redirect:/	V
								
								
								
								
								
	남은거	08:00 ~ 13시까지 작업 한 이후 남은거						
	1. 게시글 목록	완						
	2. 게시글 상세보기	완						
	3. 페이지 네이션	N						
	4. 게시글 등록	N						
	요종도?							
	랑 수정, 삭제 도있음.							
