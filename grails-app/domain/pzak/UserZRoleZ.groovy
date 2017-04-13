package pzak

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.apache.commons.lang.builder.HashCodeBuilder

@ToString(cache=true, includeNames=true, includePackage=false)
class UserZRoleZ implements Serializable {

	private static final long serialVersionUID = 1

	UserZ userZ
	RoleZ roleZ

	@Override
	boolean equals(other) {
		if (other instanceof UserZRoleZ) {
			other.userZId == userZ?.id && other.roleZId == roleZ?.id
		}
	}

	@Override
	int hashCode() {
		def builder = new HashCodeBuilder()
		if (userZ) builder.append(userZ.id)
		if (roleZ) builder.append(roleZ.id)
		builder.toHashCode()
	}

	static UserZRoleZ get(long userZId, long roleZId) {
		criteriaFor(userZId, roleZId).get()
	}

	static boolean exists(long userZId, long roleZId) {
		criteriaFor(userZId, roleZId).count()
	}

	private static DetachedCriteria criteriaFor(long userZId, long roleZId) {
		UserZRoleZ.where {
			userZ == UserZ.load(userZId) &&
			roleZ == RoleZ.load(roleZId)
		}
	}

	static UserZRoleZ create(UserZ userZ, RoleZ roleZ) {
		def instance = new UserZRoleZ(userZ: userZ, roleZ: roleZ)
		instance.save()
		instance
	}

	static boolean remove(UserZ u, RoleZ r) {
		if (u != null && r != null) {
			UserZRoleZ.where { userZ == u && roleZ == r }.deleteAll()
		}
	}

	static int removeAll(UserZ u) {
		u == null ? 0 : UserZRoleZ.where { userZ == u }.deleteAll()
	}

	static int removeAll(RoleZ r) {
		r == null ? 0 : UserZRoleZ.where { roleZ == r }.deleteAll()
	}

	static constraints = {
		roleZ validator: { RoleZ r, UserZRoleZ ur ->
			if (ur.userZ?.id) {
				UserZRoleZ.withNewSession {
					if (UserZRoleZ.exists(ur.userZ.id, r.id)) {
						return ['userRole.exists']
					}
				}
			}
		}
	}

	static mapping = {
		id composite: ['userZ', 'roleZ']
		version false
	}
}
