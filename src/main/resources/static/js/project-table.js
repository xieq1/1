class ProjectTable {
    constructor(selector = '') {
        this.selector = selector;
        this.columns = [
            { name: 'projectid', title: 'ID' },
            { name: 'projectname', title: '名称' },
            { name: 'projectcast', title: '杂费' },
            { name: 'principal', title: '负责人' },
            { name: 'builders', title: '施工人员' },
            { name: 'designplanid', title: '设计方案ID' },
            { name: 'acresult', title: '验收结果' }
        ];
        this.table = $('<table class="table table-striped"></table>');
        $(this.selector).append(this.table);
    }

    load(token) {
        return fetch('/project/getall?token=' + token)
            .then(res => res.json())
            .then(data => {
                this.data = data.map(p => ({
                    projectid: p.projectid,
                    projectname: p.projectname,
                    projectcast: p.projectcast,
                    principal: p.principal,
                    builders: p.builders,
                    designplanid: p.designplanid,
                    acresult: p.acresult
                }));
                this.render();
            });
    }

    render() {
        var headerRow = '<tr>';
        for (var i = 0; i < this.columns.length; i++) {
            headerRow += '<th>' + this.columns[i].title + '</th>';
        }
        headerRow += '</tr>';

        var contentRows = '';
        for (var i = 0; i < this.data.length; i++) {
            contentRows += '<tr>';
            for (var j = 0; j < this.columns.length; j++) {
                contentRows += '<td>' + this.data[i][this.columns[j].name] + '</td>';
            }
            contentRows += '</tr>';
        }

        this.table.html(headerRow + contentRows);
    }

    getSelectedId() {
        var index = $('.table-striped tbody tr.active').index();
        if (index >= 0) {
            return this.data[index].projectid;
        } else {
            return null;
        }
    }
}