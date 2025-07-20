package org.akhil;

import java.util.*;

public class Solution {
    private String populateNodes(TrieNode root, Map<String, Integer> subFolderMap) {
        List<Map.Entry<String, String>> subFolderPaths = new ArrayList<>();

        for (Map.Entry<String, TrieNode> entry : root.children.entrySet()) {
            String subFolderResult = populateNodes(entry.getValue(), subFolderMap);
            subFolderPaths.add(new AbstractMap.SimpleEntry<>(entry.getKey(), subFolderResult));
        }

        subFolderPaths.sort(Comparator.comparing(Map.Entry::getKey));

        StringBuilder completePath = new StringBuilder();
        for (Map.Entry<String, String> entry : subFolderPaths) {
            completePath.append("(").append(entry.getKey()).append(entry.getValue()).append(")");
        }

        root.subFolder = completePath.toString();

        if (!completePath.toString().isEmpty()) {
            subFolderMap.put(completePath.toString(), subFolderMap.getOrDefault(completePath.toString(), 0) + 1);
        }

        return completePath.toString();
    }

    private void removeDuplicates(TrieNode root, Map<String, Integer> subFolderMap) {
        Iterator<Map.Entry<String, TrieNode>> it = root.children.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, TrieNode> entry = it.next();
            TrieNode child = entry.getValue();

            if (!child.subFolder.isEmpty() && subFolderMap.get(child.subFolder) > 1) {
                it.remove();
            } else {
                removeDuplicates(child, subFolderMap);
            }
        }
    }

    private void construstResult(TrieNode root, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : root.children.entrySet()) {
            path.add(entry.getKey());
            result.add(new ArrayList<>(path));
            construstResult(entry.getValue(), path, result);
            path.remove(path.size() - 1);
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode("/");

        // Construct trie
        for (List<String> path : paths) {
            insert(root, path);
        }

        Map<String, Integer> subFolderMap = new HashMap<>();
        populateNodes(root, subFolderMap);

        removeDuplicates(root, subFolderMap);

        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        construstResult(root, path, result);

        return result;
    }

    private void insert(TrieNode root, List<String> path) {
        for (String folder : path) {
            root.children.putIfAbsent(folder, new TrieNode(folder));
            root = root.children.get(folder);
        }
    }
}
