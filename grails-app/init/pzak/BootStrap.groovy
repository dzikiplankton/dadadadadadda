package pzak

class BootStrap {

    def init = { servletContext ->

        def puggerfly = new Creature(
                name: "Puggerfly",
                description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer non finibus sapien. Curabitur tincidunt pulvinar neque eu ultricies. Duis ac feugiat quam. Vestibulum est massa, scelerisque vitae purus ut, dapibus mollis nisi. Maecenas ut tortor sed ex luctus congue. Sed dui ante, mattis et maximus nec, efficitur nec nulla. Nulla faucibus nunc at velit lacinia euismod. Sed sed cursus ligula. Morbi tempus volutpat mi. Vivamus blandit, enim et ornare blandit, eros massa posuere tellus, ac vestibulum ligula mauris et ligula. Suspendisse potenti. Pellentesque habitant morbi tristique senectus et netus et.",
                link:"https://pbs.twimg.com/media/B-z__bHUEAAB0o0.jpg:large"
        ).save()
        def puggerpillar = new Creature(name: "Puggerpillar",
                description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer non finibus sapien. Curabitur tincidunt pulvinar neque eu ultricies. Duis ac feugiat quam. Vestibulum est massa, scelerisque vitae purus ut, dapibus mollis nisi. Maecenas ut tortor sed ex luctus congue. Sed dui ante, mattis et maximus nec, efficitur nec nulla. Nulla faucibus nunc at velit lacinia euismod. Sed sed cursus ligula. Morbi tempus volutpat mi. Vivamus blandit, enim et ornare blandit, eros massa posuere tellus, ac vestibulum ligula mauris et ligula. Suspendisse potenti. Pellentesque habitant morbi tristique senectus et netus et.y"
                , link:"https://i.ytimg.com/vi/6YLosC0x_wo/maxresdefault.jpg"
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
