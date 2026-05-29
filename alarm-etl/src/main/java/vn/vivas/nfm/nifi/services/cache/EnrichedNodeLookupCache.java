package vn.vivas.nfm.nifi.services.cache;

import vn.vivas.nfm.nifi.models.EnrichedNode;
import vn.vivas.nfm.nifi.parsers.EnrichedNodeParser;

import java.io.IOException;

public class EnrichedNodeLookupCache {

    private static final String ENRICHED_NODE_KEY = "nfm:alarm-etl:enriched-node";
    private final CacheService cacheService;
    public EnrichedNodeLookupCache(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public EnrichedNode find(String nodeCode) throws IOException {
        String data = cacheService.get(this.getKeyFromNodeCode(nodeCode));
        if (data == null) throw new IOException("No data found for node code " + nodeCode);
        return EnrichedNodeParser.parseEnrichedNodeFromString(data);
    }

    private String getKeyFromNodeCode(String nodeCode) {
        return ENRICHED_NODE_KEY + ":" + nodeCode;
    }
}
