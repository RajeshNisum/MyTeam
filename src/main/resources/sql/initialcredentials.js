var db = connect('localhost:27017/mytime-demo');

db.UserAccount.drop();
var userAccount = [         
	{
            "_class" : "com.nisum.mytime.model.UserAccount",
	    "username" : "admin",
	    "password" : "admin",
	    "roles" : [ 
	        {
	            "role" : "ADMIN_ROLE",
                    "_class" : "org.springframework.security.core.authority.SimpleGrantedAuthority"
	        }
	    ]
	},
	{
            "_class" : "com.nisum.mytime.model.UserAccount",
	    "username" : "user",
	    "password" : "user",
	    "roles" : [ 
	        {
	            "role" : "USER_ROLE",
                    "_class" : "org.springframework.security.core.authority.SimpleGrantedAuthority"
	        }
	    ]
	}
];
for (i = 0; i < userAccount.length; i++) {
	db.UserAccount.insert(userAccount[i]);
}