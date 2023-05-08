<template>
    <div></div>
</template>

<script>
    const axios = require('axios').default;

    export default{
        name: 'department-base',
        props: {
            offline: Boolean
        },
        computed: {},
        data: () => ({
            values: [],
            newValue: {},
            isUpdating: false,
        }),
        methods:{
            closeDialog(){
                this.openDialog = false
                location.reload()
            },
            append(value){
                this.tick = false
                this.newValue = {}
                this.values.push(value)
                this.$emit('input', this.values);
                this.$nextTick(function(){
                    this.tick=true
                })
            },
            remove(value){
                var where = -1;
                for(var i=0; i<this.values.length; i++){
                    if(this.values[i]._links.self.href == value._links.self.href){
                        where = i;
                        break;
                    }
                }
                if(where > -1){
                    this.values.splice(i, 1);
                    this.$emit('input', this.values);
                }
            },
            async getRealEntity(id){
               try{
                    let result = await axios.get(axios.fixUrl(`/departments/${id}`))
                    result.data.id = id;
                    return result.data;
                }catch(e){
                    return null;
                }
            },
            async search(query) {
                var me = this;
                if(me.offline){
                    if(!me.values) me.values = [];
                    return;
                } 
                var temp = null;
                if(query!=null){
                    temp = await axios.get(axios.fixUrl('/departments/' + query.apiPath), {params: query.parameters})
                }else{
                    temp = await axios.get(axios.fixUrl('/departments'))
                }
                let departments = temp.data._embedded.departments
                
                return departments;
            },
        },

    }

</script>