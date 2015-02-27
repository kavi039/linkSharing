class BootStrap {

    def bootStrapService

    def init = { servletContext ->
        bootStrapService.bootStrap()
    }
    def destroy = {
    }
}
