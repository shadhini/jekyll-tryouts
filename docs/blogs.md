---
title: Blog
---

# Latest Posts

<ul>
    {% for post in site.posts %}
    <li>
        <h2 style="border-bottom: 0px"><a href="{{ site.baseurl }}{{ post.url }}">{{ post.title }}</a></h2>
        <p>Written by: <span class="badge bg-info">{{ post.author }}</span></p>
    </li>
    {% endfor %}
</ul>