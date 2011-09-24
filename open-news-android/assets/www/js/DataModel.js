/**
 * 
 */

Ext.regModel('Report', {
    idProperty: 'id',
    fields: [
        { name: 'id', type: 'int' },
        { name: 'date', type: 'date', dateFormat: 'c' },
        { name: 'title', type: 'string' },
        { name: 'content', type: 'string' }
    ],
    validations: [
        { type: 'presence', field: 'id' },
        { type: 'presence', field: 'title' }
    ]
});

Ext.regStore('ReportsStore', {
    model: 'Report',
    sorters: [{
        property: 'date',
        direction: 'DESC'
    }],
    proxy: {
        type: 'localstorage',
        id: 'report-app-localstore'
    },
    // test data
    data: [
        { id: 1, date: new Date(), title: 'Baradak obama says:..', content: 'the middle east countries were all shoked...' },
        { id: 2, date: new Date(), title: 'Horses in the wild', content: 'animal planet ?   no more.' },
        { id: 3, date: new Date(), title: 'Rage against the machine', content: 'what the machine did,that rage is against him.' }
        ]
});
