package pzak

class BootStrap {

    def init = { servletContext ->

        def puggerfly = new Creature(
                name: "Puggerfly",
                description: "According to legends only the one with pure hart and pockets full of treats can see the Puggerfly. \"Their song, though irresistibly sweet, was no less sad than sweet, and lapped both body and soul in a fatal lethargy.\" The ones that seen a puggerfly have lost ability to leave them. Their unrealistic beauty captivates one for lifetime.",
                link:"https://pbs.twimg.com/media/B-z__bHUEAAB0o0.jpg:large"
        ).save()
        def puggerpillar = new Creature(name: "Puggerpillar",
                description: "The beauty of a Puggerpillar Is not in the clothes it wears, The figure that it carries, Or the way it combs its hair. The beauty of a Puggerpillar must be seen from in its eyes, Because that is the doorway to its heart, the place where love resides. The beauty of a Puggerpillar is not in a facial mole, But true beauty in a Puggerpillar Is reflected in its soul. It is the caring that it lovingly gives, The passion that it shows, And the beauty of a Puggerpillar With passing years only grows.",
                link:"https://i.ytimg.com/vi/6YLosC0x_wo/maxresdefault.jpg"
        ).save()
        def pugmpkin = new Creature(name: "Pugmpkin",
                description: "Each year, as the last of the crops come to harvest, there's a chance that you might see a Pumpkin Monster standing near your fields! Some scholars conjecture that they're the result of plant and earth magics coming together at this special time of the year. Others say they're just hungry and looking for a snack."
                , link:"http://cdn.pcwallart.com/images/pug-in-pumpkin-costume-wallpaper-2.jpg"
        ).save()


        def adminRole = new RoleZ(authority: 'ROLE_ADMIN').save()
        def userRole = new RoleZ(authority: 'ROLE_USER').save()

        def testUser = new UserZ(username: 'me', password: 'doug').save()

        UserZRoleZ.create testUser, adminRole

        UserZRoleZ.withSession {
            it.flush()
            it.clear()
        }


    }
    def destroy = {
    }
}
