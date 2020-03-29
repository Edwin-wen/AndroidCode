package com.example.edwin.knowledgecode.activity.fragment.dummy;

public class FragmentListItem {
    public final String content;
    public final Class<?> jumpToClass;

    public FragmentListItem(String content, Class<?> jumpTO) {
        this.content = content;
        this.jumpToClass = jumpTO;
    }

    @Override
    public String toString() {
        return content;
    }
}
