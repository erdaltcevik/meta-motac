
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
  file://share/dot.bashrc_INC \
"
#
#

do_install:append(){

  cat ${WORKDIR}/share/dot.bashrc_INC >> ${D}${sysconfdir}/skel/.bashrc


}
