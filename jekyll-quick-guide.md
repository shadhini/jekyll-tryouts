#### Configuration
`_config.yml`
```yaml
# Base URL: if your site is hosted at https://username.github.io/repository-name
baseurl: "/jekyll-tryouts"
```

#### Navigation
`_includes/navigation.html`

data file: `_data/navigation.yml`
```yaml
- name: Home
  link: "{{ site.baseurl }}/"
- name: About
  link: "{{ site.baseurl }}/about.html"
```
