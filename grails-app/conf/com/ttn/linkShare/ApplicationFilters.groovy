package com.ttn.linkShare

class ApplicationFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
              //   println("*********** In all, params: ${params}")
                log.info("params :${params - params?.get("passsword")}")

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }

//        secureAction(controller: 'login',action: 'login|loginHandler',invert: true) {
        secureAction(controller: '*',action: '*', actionExclude: "login|loginHandler") {
            before = {
                if (!session.getAttribute('username')) {
                    println "************in secure filter ${controllerName}/${actionName}"
                    flash.error = "Please login "
                    redirect(controller: "login", action: "login")
                }
            }
        }

        isAdmin(controller: 'user', action: 'listOfUser') {
            before = {
                if (!User.findByUsername(session['username'])?.admin) {
                    flash.error = "Permission denied"
                    redirect(controller:'user',action: 'dashBoard')
                    return
                }
            }
        }
    }
}
