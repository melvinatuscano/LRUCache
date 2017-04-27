Double linked list maintains list of elements in cache. start points to most recently used and end points to least recently used element.
After every insert/get call we move element to start to maintain state of most recently used.

Map is used for easy caching and faster access to elements in cache.