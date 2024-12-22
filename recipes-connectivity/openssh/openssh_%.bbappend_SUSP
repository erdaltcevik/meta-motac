
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
  file://sshd_config_inc \
"

do_install:append(){

##  cat ${WORKDIR}/sshd_config_inc >> ${D}${sysconfdir}/ssh/sshd_config

}
