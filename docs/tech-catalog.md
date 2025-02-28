---
title: "Tech Catalog"
---

# Tech Catalog

## Technologies
<table class="table table-hover table-bordered">
    <thead>
    <tr>
        <th></th>
        <th class="text-success-emphasis">Support Files</th>
        <th class="text-success-emphasis">Related Topics</th>
        <th class="text-success-emphasis">Similar Technologies</th>
    </tr>
    </thead>
    <tbody>
    {% for technology in site.technologies %}
        <tr>
            <!-- Technology Name -->
            <td><strong class="text-success-emphasis">{{ technology.title }}</strong></td>
            <!-- Support Files -->
            <td></td>
            <!-- Related Topics -->
            <td>
                {% for topic in site.data.technologies[technology.slug].topics %}
                {% assign topic_slug = topic | slugify %}
                <span class="badge bg-secondary">
                    <a href="{{ site.baseurl }}/topics/{{ topic_slug }}" target="_blank" data-bs-theme="light">
                        {{ topic }}
                    </a>
                </span>
                {% endfor %}
            </td>
            <!-- Similar Technologies -->
            <td>
                {% for similar_technology in site.data.technologies[technology.slug].similar-technologies %}
                {% assign similar_technology_slug = similar_technology | slugify %}
                <span class="badge bg-secondary">
                    <a href="{{ site.baseurl }}/technologies/{{ similar_technology_slug }}" target="_blank" data-bs-theme="light">
                        {{ similar_technology }}
                    </a>
                </span>
                {% endfor %}
            </td>
        </tr>
    {% endfor %}
    </tbody>
</table>


## Topics

<table class="table table-hover table-bordered">
    <thead>
    <tr>
        <th></th>
        <th class="text-success-emphasis">Support Files</th>
        <th class="text-success-emphasis">Related Technologies</th>
        <th class="text-success-emphasis">Related Topics</th>
    </tr>
    </thead>
    <tbody>
    {% for topic in site.topics %}
        <tr>
            <!-- Topic Name -->
            <td><strong class="text-success-emphasis">{{ topic.title }}</strong></td>
            <!-- Support Files -->
            <td></td>
            <!-- Related Technologies -->
            <td>
                {% for technology in site.data.topics[topic.slug].technologies %}
                {% assign technology_slug = technology | slugify %}
                <span class="badge bg-secondary">
                    <a href="{{ site.baseurl }}/technologies/{{ technology_slug }}" target="_blank" data-bs-theme="light">
                        {{ technology }}
                    </a>
                </span>
                {% endfor %}
            </td>
            <!-- Related Topics -->
            <td>
                {% for related_topic in site.data.topics[topic.slug].related-topics %}
                {% assign related_topic_slug = related_topic | slugify %}
                <span class="badge bg-secondary">
                    <a href="{{ site.baseurl }}/topics/{{ related_topic_slug }}" target="_blank" data-bs-theme="light">
                        {{ related_topic }}
                    </a>
                </span>
                {% endfor %}
            </td>
        </tr>
    {% endfor %}
    </tbody>
</table>