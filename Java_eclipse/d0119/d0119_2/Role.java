package d0119_2;

public enum Role {
	ADMIN {
		@Override
		void go() {
			System.out.println("관리자 페이지에 접속합니다.");
		}
	},
	MEMBER {
		@Override
		void go() {
			System.out.println("회원 페이지에 접속합니다.");
		}
	},
	GUEST{
		@Override
		void go() {
			System.out.println("비회원 페이지에 접속합니다.");
		}
	};
	abstract void go();
}
