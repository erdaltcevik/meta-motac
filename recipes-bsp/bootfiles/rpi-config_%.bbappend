FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
  file://config.txt \
"

do_deploy(){
   CONFIG=${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
   install -d ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}

   cp ${WORKDIR}/config.txt $CONFIG

}
