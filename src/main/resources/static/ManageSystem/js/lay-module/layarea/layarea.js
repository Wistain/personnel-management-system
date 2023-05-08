layui.define(['layer', 'form', 'laytpl'], function (exports) {
    "use strict";
    let $ = layui.$
        , form = layui.form
        , layarea = {
        _id: 0
        , config: {}
        , set: function (options) {
            let that = this;
            that.config = $.extend({}, that.config, options);
            return that;
        }
        , on: function (events, callback) {
            return layui.onevent.call(this, 'layarea', events, callback);
        }
    }
        , thisArea = function () {
        let that = this;
        return {
            layarea: function (files) {
                that.layarea.call(that, files);
            }
            , config: that.config
        }
    }
        , Class = function (options) {
        let that = this;
        that.config = $.extend({}, that.config, layarea.config, options);
        that.render();
    };

    let areaList = {
        department_list: {
            1: '计算机科学与工程',
			2: '建筑学',
			3: '医学'
        },
        major_list: {
            10: '数据科学与大数据技术',
			11: '软件工程',
			12: '物联网',
			20: '土木工程',
			21: '风景园林',
			22: '城乡规划',
			30: '基础医学',
			31: '临床医学',
			32: '麻醉学'
        }
    };

    Class.prototype.config = {
        elem: '',
        data: {
            department: '',
            major: '',
            departmentCode: 0,
            majorCode: 0,
        },
        change: function(result){}
    };

    Class.prototype.index = 0;

    Class.prototype.render = function () {
        let that = this, options = that.config;
        options.elem = $(options.elem);
        options.bindAction = $(options.bindAction);

        that.events();
    };

    Class.prototype.events = function () {
        let that = this, options = that.config, index;
        let departmentFilter = 'department-' + layarea._id;
        let majorFilter = 'major-' + layarea._id;

        let departmentEl = options.elem.find('.department-selector');
        let majorEl = options.elem.find('.major-selector');

        //filter
        if(departmentEl.attr('lay-filter')){
            departmentFilter = departmentEl.attr('lay-filter');
        }
        if(majorEl.attr('lay-filter')){
            majorFilter = majorEl.attr('lay-filter');
        }
		
        departmentEl.attr('lay-filter', departmentFilter);
        majorEl.attr('lay-filter', majorFilter);

        //获取默认值
        if(departmentEl.data('value')){
            options.data.department = departmentEl.data('value');
            options.data.departmentCode = getCode('department', options.data.department);
        }
        if(majorEl.data('value')){
            options.data.major = majorEl.data('value');
            let code = getCode('major', options.data.major, options.data.departmentCode.slice(0, 2));
            options.data.majorCode = code;
        }
		
        departmentEl.attr('lay-filter', departmentFilter);
        majorEl.attr('lay-filter', majorFilter);

        //监听结果
        form.on('select('+departmentFilter+')', function(data){
            options.data.department = data.value;
            options.data.departmentCode = getCode('department', data.value);
            renderMajor(options.data.departmentCode);

            options.change(options.data);
        });
        renderDepartment();

        //查找department
        function renderDepartment(){
            let tpl = '<option value="">--选择系--</option>';
            let departmentList = getList("department");
            let currentCode = '';
            let currentName = '';
            departmentList.forEach(function(_item){
                if(_item.name === options.data.department){
                    currentCode = _item.code;
                    currentName = _item.name;
                }
                tpl += '<option value="'+_item.name+'">'+_item.name+'</option>';
            });
            departmentEl.html(tpl);
            departmentEl.val(options.data.department);
            form.render('select');
            renderMajor(currentCode);
        }

        function renderMajor(departmentCode){
            let tpl = '<option value="">--选择专业--</option>';
            let majorList = getList('major', departmentCode.slice(0, 2));
            let currentCode = '';
            let currentName = '';
            majorList.forEach(function(_item){
                if(_item.name === options.data.major){
                    currentCode = _item.code;
                    currentName = _item.name;
                }
                tpl += '<option value="'+_item.name+'">'+_item.name+'</option>';
            });
            options.data.major = currentName;
            majorEl.html(tpl);
            majorEl.val(options.data.major);
            form.render('select');
        }

        function getList(type, code) {
            let result = [];

            if (type !== 'department' && !code) {
                return result;
            }

            let list = areaList[type + "_list"] || {};
            result = Object.keys(list).map(function (code) {
                return {
                    code: code,
                    name: list[code]
                };
            });

            if (code) {
                // oversea code
                if (code[0] === '9' && type === 'major') {
                    code = '9';
                }

                result = result.filter(function (item) {
                    return item.code.indexOf(code) === 0;
                });
            }

            return result;
        }

        function getCode(type, name, parentCode = 0){
            let code = '';
            let list = areaList[type + "_list"] || {};
            let result = {};
            Object.keys(list).map(function (_code) {
                if(parentCode){
                    if(_code.indexOf(parentCode) === 0){
                        result[_code] = list[_code];
                    }
                }else{
                    result[_code] = list[_code];
                }
            });
            layui.each(result, function(_code, _name){
                if(_name === name){
                    code = _code;
                }
            });

            return code;
        }
    };

    layarea.render = function (options) {
        let inst = new Class(options);
        layarea._id++;
        return thisArea.call(inst);
    };

    //暴露接口
    exports('layarea', layarea);
});