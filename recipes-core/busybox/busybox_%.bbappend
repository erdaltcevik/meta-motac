
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
  file://motac-dvl.cfg \
"
#
# 
#

do_install:append(){

##   install -m 0644 ${WORKDIR}/fstab ${D}${sysconfdir}

}