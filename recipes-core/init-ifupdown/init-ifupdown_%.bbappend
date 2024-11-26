FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
  file://interfaces \
"
#
#

do_install:append(){

  cp ${WORKDIR}/interfaces  ${D}${sysconfdir}/network/interfaces

}
