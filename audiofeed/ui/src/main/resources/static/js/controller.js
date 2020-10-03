
var subscriberApi = new Vue.resource('/controller/subscribers{/id}');

// Vue.component('subscriber-list',{
//     props: ['subscribers'],
//     template: '<subscriber-row v-for="subscriber in subscribers" :key="subscriber.id" :subscriber="subscriber" />',
//
//     created: function () {
//         subscriberApi.get().then(result =>
//         result.json().then(data =>
//         console.log(data)))
//     }
// });


function getIndex(list, id) {
    for (var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }

    return -1;
}


var messageApi = Vue.resource('/message{/id}');

Vue.component('subscriber-form', {
    props: ['subscribers', 'subscriberAttr'],
    data: function() {
        return {
            text: '',
            id: ''
        }
    },
    watch: {
        subscriberAttr: function(newVal, oldVal) {
            this.text = newVal.text;
            this.id = newVal.id;
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="Write something" v-model="text" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function() {
            var subscriber = { text: this.text };

            if (this.id) {
                subscriberApi.update({id: this.id}, subscriber).then(result =>
                result.json().then(data => {
                    var index = getIndex(this.subscribers, data.id);
                this.subscribers.splice(index, 1, data);
                this.text = ''
                this.id = ''
            })
            )
            } else {
                subscriberApi.save({}, subscriber).then(result =>
                result.json().then(data => {
                    this.subscribers.push(data);
                this.text = ''
            })
            )
            }
        }
    }
});

Vue.component('subscriber-row', {
    props: ['subscriber', 'editMethod', 'subscribers'],
    template: '<div>' +
        '<i>({{ subscriber.id }})</i> {{ subscriber.text }}' +
        '<span style="position: absolute; right: 0">' +
        '<input type="button" value="Edit" @click="edit" />' +
        '<input type="button" value="X" @click="del" />' +
        '</span>' +
        '</div>',
    methods: {
        edit: function() {
            this.editMethod(this.subscriber);
        },
        del: function() {
            subscriberApi.remove({id: this.subscriber.id}).then(result => {
                if (result.ok) {
                this.subscribers.splice(this.subscribers.indexOf(this.subscriber), 1)
            }
        })
        }
    }
});

Vue.component('subscribers-list', {
    props: ['subscribers'],
    data: function() {
        return {
            subscriber: null
        }
    },
    template:
        '<div style="position: relative; width: 300px;">' +
        '<subscriber-form :messages="subscribers" :subscriberAttr="subscribers" />' +
        '<subscriber-row v-for="subscriber in subscribers" :key="subscriber.id" :subscriber="subscriber" ' +
        ':editMethod="editMethod" :subscribers="subscribers" />' +
        '</div>',
    created: function() {
        subscriberApi.get().then(result =>
        result.json().then(data =>
        console.log(data)
    )
    )
    },
    methods: {
        editMethod: function(subscriber) {
            this.subscriber = subscriber;
        }
    }
});

var app = new Vue({
    el: '#app',
    template: '<subscribers-list :subscribers="subscribers" />',
    data: {
        subscribers: []
    }
});
