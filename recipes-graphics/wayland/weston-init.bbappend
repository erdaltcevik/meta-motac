FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

##DEPENDS:remove = "docker-ce"

SRC_URI:append = " \
  file://weston.ini \
  file://init \
"
#
#
#    file://weston.service \
#

do_install:append() {

}

USERADD_PARAM:${PN} = "-u 1001 --user-group -G video,input,render,wayland weston"


# Set password for the user "weston"
# use "mkpasswd -m MD5 weston" to get the password hash
# escape the '$' chars inside the hash
##PASSWD = "\$1\$/7GQMJwI\$hhUDyjzgZOdJkwQRnEU9T0"
##USERADD_PARAM:${PN} =+ " -p '${PASSWD}' "

# Allow for empty password for the user "weston"
##USERADD_PARAM:${PN} =+ " -p '' "
