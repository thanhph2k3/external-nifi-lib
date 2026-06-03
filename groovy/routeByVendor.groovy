import vn.vivas.nfm.nifi.service.AlarmRoutingService
import vn.vivas.nfm.nifi.model.AlarmSNMPTrap
import vn.vivas.nfm.nifi.cache.NiFiCacheService
import vn.vivas.nfm.nifi.parser.JsonStringParser

def mapCacheClientService = CTL['MapCacheClientService']
if (!mapCacheClientService) return

def flowFiles = session.get(100)
if (!flowFiles) return

def cacheService = new NiFiCacheService(mapCacheClientService)
def alarmRoutingService = new AlarmRoutingService(cacheService)

flowFiles.each { flowFile ->
    try {
        def flowFileContent = session.read(flowFile).getText("UTF-8")
        def snmpTrap = JsonStringParser.parseObjectFromString(flowFileContent)
        def alarmSNMPWithRouting = alarmRoutingService.route(new AlarmSNMPTrap(snmpTrap))

        flowFile = session.putAttribute(flowFile, "alarm.routing.vendor", alarmSNMPWithRouting.alarmEnrichment().getDeviceVendor().getCode())
        flowFile = session.putAttribute(flowFile, "alarm.routing.device_sys_group", alarmSNMPWithRouting.alarmEnrichment().getDeviceSysGroup().getCode())
        flowFile = session.putAttribute(flowFile, "alarm.routing.device_group", alarmSNMPWithRouting.alarmEnrichment().getDeviceGroup().getCode())
        flowFile = session.putAttribute(flowFile, "alarm.routing.device", alarmSNMPWithRouting.alarmEnrichment().getDevice().getCode())

        session.transfer(flowFile, REL_SUCCESS)
    } catch (Exception e) {
        flowFile = session.putAttribute(flowFile, "error.message", e.getMessage())
        session.transfer(flowFile, REL_FAILURE)
    }
}
