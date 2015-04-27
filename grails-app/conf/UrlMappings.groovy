class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
     //  "/" view:'/login/login'
        "/"(controller: "user",action: "dashBoard")
        "500"(view:'/error/error')

	}


}
