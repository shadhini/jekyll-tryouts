---
title: Authors
---

# Authors

<ul>
    {% for author in site.authors %}
    <li>
        <h2 style="border-bottom: 0px"><a href="{{ site.baseurl }}{{ author.url }}">{{ author.name }}</a></h2>
        <span class="badge bg-info">{{ author.position }}</span>
        <p>{{ author.content }}</p>
    </li>
    {% endfor %}
</ul>