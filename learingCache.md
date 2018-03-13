## 关于缓存的更新：    
### 缓存更新的策略:  
- Cache Aside Pattern:    
  - 失效：应用程序先从cache取数据，没有得到，则从数据库中取数据，成功后，放到Cache中;  
  - 命中：应用程序从cache中取数据，取到后返回;  
  - 更新：先把数据存到数据库中，成功后，再让缓存失效。  
- Read/Wrirte Through Pattern  
  - Read Through 查询操作中更新缓存  
  - Write Through 在更新数据时，当有数据更新的时候，如果没有命中缓存，直接更新数据库，然后返回。如果命中了缓存，
  则更新缓存，然后再由Cache自己更新数据库。  
- Wrirte Behind Cacaing Pattern  
  - 在更新数据的时候，只更新缓存，不更新数据库，而缓存会异步批量更新数据库。
