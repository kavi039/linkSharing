package com.ttn.linkShare

class ApplicationFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                //   println("*********** In all, params: ${params}")
                log.info("params :${params - (params?.get("passsword"))}")

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }

//        secureAction(controller: 'login',action: 'login|loginHandler',invert: true) {
        secureAction(controller: '*', action: '*', actionExclude: "login|loginHandler|registerHandler|forgetPassword|forgetPasswordAction|post|renderImage|user|downloadAction|viewFullSite|recentShare|topPostAction|publicTopicCreatedByUser|publicResourceListCreatedByUser|search|searchPaginationOnText|uniqueEmailCheckerOrUsername") {
            before = {
                if (!session.getAttribute('username')) {
//                    println "************in secure filter ${controllerName}/${actionName}"
//                    flash.error = "login first to view this page "
                    redirect(controller: "login", action: "login")
                }
            }

        }
                loginHandler(controller: 'login',action: 'login'){
                    before={
                        if (session.getAttribute('username')) {
//                    println "************in secure filter ${controllerName}/${actionName}"
//                    flash.error = "login first to view this page "
                            redirect(controller: "user", action: "dashBoard")
                        }
                    }
                }


    }

}
