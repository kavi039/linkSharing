package com.ttn.linkShare

class ApplicationFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                log.info("params :${params-params.get("passsword")}")

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }

      secureAction(controller:'login',action: 'login|loginhandler|registerhandler', invert: true) {

     before = {
           if (!session.getAttribute('username')) {
                flash.error = "Please login "
              //   redirect(controller: "login", action: "login")
                 return
              }
           }
       }
       // actionExcludeAction(controllerName:'login',actionExclude: 'login',action: "*"){
        //    before = {
           //     if (!session.getAttribute('username')) {
                //    flash.error = "Please login "
                    // redirect(controller: "login", action: "login")
               //     return
               //}
         //   }
       // }

        isAdmin(controller: 'user', action: 'list') {
            before = {
                if (!User.findByUsername(session['username'])?.admin) {
                    flash.error = "Permission denied"
                  //  redirect(controller: 'user', action: 'dashBoard')
                    return
                }
            }
        }
    }
}
