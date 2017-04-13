package pzak

import grails.plugin.springsecurity.annotation.Secured


@Secured('ROLE_ADMIN')
class CreatureController {

    static scaffold = Creature

}
