import com.ig.ttn.User
import enums.Visibility

class BootStrap {

    def init = { servletContext ->
        List<User> l = createUsers();
        l.each {
            println it
        }
    }
    def destroy = {
    }

    List<User> createUsers() {
        User user
        2.times {
            user = new User(email: "kavita${it}@gmail.com ", username: "kavita", password: 1234, firstName: "kavita", lastName: "bora",
                    admin: true, active: true)
            if (user.save())
                println "userCreated";
            else
                println "not created"
        }
    }

}
