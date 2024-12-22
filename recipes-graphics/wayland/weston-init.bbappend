FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
  file://weston.ini \
  file://init \
"
#
#
#    file://weston.service \
#

do_install() {
  # Install weston-start script
  if [ "${VIRTUAL-RUNTIME_init_manager}" != "systemd" ]; then
    install -Dm755 ${WORKDIR}/weston-start ${D}${bindir}/weston-start
    sed -i 's,@DATADIR@,${datadir},g' ${D}${bindir}/weston-start
    sed -i 's,@LOCALSTATEDIR@,${localstatedir},g' ${D}${bindir}/weston-start
    install -Dm755 ${WORKDIR}/init ${D}/${sysconfdir}/init.d/weston
    sed -i 's#ROOTHOME#${ROOT_HOME}#' ${D}/${sysconfdir}/init.d/weston
  fi

  install -D -p -m0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
  install -Dm644 ${WORKDIR}/weston.env ${D}${sysconfdir}/default/weston
  
##  install -dm 755 -o erdal -g erdal ${D}/home/erdal
}

# Password: "erdal"
# printf "%q" $(mkpasswd -m sha256crypt erdal)
PASSWD = "\$5\$Tklv72xH8CmdNdaI\$pf7A2jR/s1eokny1KP0fsGQNz4LIvy2UukZ/ndi4bn2"

USERADD_PARAM:${PN} = "-p '${PASSWD}' --home /home/erdal --shell /bin/sh --user-group -G video,input,render,wayland erdal"


# Set password for the user "weston"
# use "mkpasswd -m MD5 weston" to get the password hash
# escape the '$' chars inside the hash
##PASSWD = "\$1\$/7GQMJwI\$hhUDyjzgZOdJkwQRnEU9T0"
##USERADD_PARAM:${PN} =+ " -p '${PASSWD}' "

# Allow for empty password for the user "weston"
##USERADD_PARAM:${PN} =+ " -p '' "





