
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
  file://wired.nmconnection \
"
#   file://dns.conf \
#  
#  

do_install:append(){

  install -m 0600 ${WORKDIR}/wired.nmconnection  ${D}${sysconfdir}/NetworkManager/system-connections/

##   install -m 0644 ${WORKDIR}/dns.conf  ${D}${sysconfdir}/NetworkManager/conf.d/

}

PACKAGECONFIG:remove = " ifupdown dnsmasq  vala "
