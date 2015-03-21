import com.ttn.linkShare.User

class BootStrap {

    def bootStrapService

    def init = { servletContext ->
        if(!User.count()) {
            bootStrapService.bootStrap()
        }
    }
    def destroy = {
    }
}
