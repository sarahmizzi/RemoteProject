package com.sarahmizzi.fyp.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sarah on 06-Feb-16.
 */
public class JsonUtils {
    public static String stringFromJsonNode(JsonNode node, String key) {
        if (node == null) return null;
        JsonNode value = node.get(key);
        if (value == null) return null;
        return value.textValue();
    }

    public static String stringFromJsonNode(JsonNode node, String key, String defaultValue) {
        if (node == null) return defaultValue;
        JsonNode value = node.get(key);
        if (value == null) return defaultValue;
        return value.textValue();
    }

    public static double doubleFromJsonNode(JsonNode node, String key) {
        return doubleFromJsonNode(node, key, 0);
    }

    public static double doubleFromJsonNode(JsonNode node, String key, double defaultValue) {
        if (node == null) return defaultValue;
        JsonNode value = node.get(key);
        if (value == null) return defaultValue;
        return value.asDouble();
    }

    public static int intFromJsonNode(JsonNode node, String key) {
        if (node == null) return 0;
        JsonNode value = node.get(key);
        if (value == null) return 0;
        return value.asInt();
    }

    public static int intFromJsonNode(JsonNode node, String key, int defaultValue) {
        if (node == null) return defaultValue;
        JsonNode value = node.get(key);
        if (value == null) return defaultValue;
        return value.asInt();
    }

    public static boolean booleanFromJsonNode(JsonNode node, String key) {
        return booleanFromJsonNode(node, key, false);
    }

    public static boolean booleanFromJsonNode(JsonNode node, String key, boolean defaultValue) {
        if (node == null) return defaultValue;
        JsonNode value = node.get(key);
        if (value == null) return defaultValue;
        return value.asBoolean();
    }

    public static List<String> stringListFromJsonNode(JsonNode node, String key) {
        if (node == null) return new ArrayList<String>(0);
        JsonNode value = node.get(key);
        if (value == null) return new ArrayList<String>(0);

        ArrayList<String> result;
        if (value.isArray()) {
            ArrayNode arrayNode = (ArrayNode) value;
            result = new ArrayList<String>(arrayNode.size());
            for (JsonNode innerNode : arrayNode) {
                result.add(innerNode.textValue());
            }
        } else {
            result = new ArrayList<>(1);
            result.add(value.textValue());
        }
        return result;
    }

    public static List<Integer> integerListFromJsonNode(JsonNode node, String key) {
        if (node == null) return new ArrayList<>(0);
        JsonNode value = node.get(key);
        if (value == null) return new ArrayList<>(0);

        ArrayList<Integer> result;
        if (value.isArray()) {
            ArrayNode arrayNode = (ArrayNode) value;
            result = new ArrayList<>(arrayNode.size());
            for (JsonNode innerNode : arrayNode) {
                result.add(innerNode.asInt());
            }
        } else {
            result = new ArrayList<>(1);
            result.add(value.asInt());
        }
        return result;
    }
}
