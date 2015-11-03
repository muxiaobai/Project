package DataBaseTable;

public class Role {
		private int role_id;
		private String role_name;
		public int getRole_id() {
			return role_id;
		}
		public void setRole_id(int role_id) {
			this.role_id = role_id;
		}
		public String getRole_name() {
			return role_name;
		}
		public void setRole_name(String role_name) {
			this.role_name = role_name;
		}
		@Override
		public String toString() {
			String Role;
			Role="role_id:"+role_id+"\n"+"role_name:"+role_name;
			return Role;
		}
		
}
