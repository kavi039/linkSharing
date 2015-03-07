package com.ttn.linkShare

class ApplicationFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                 println("***********in all")
                log.info("params :${params - params?.get("passsword")}")

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }

        secureAction(controller: 'login',action: 'login|loginHandler',invert: true) {

            before = {
                if (!session.getAttribute('username')) {
                    println "************in secure filter"
                    flash.error = "Please login "
//                    redirect(controller: "login", action: "login")
                    return
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
