// ==UserScript==
// @name         解除复制限制
// @namespace    http://tampermonkey.net/
// @version      1.3
// @description  解除网站复制、右键菜单和选择限制
// @author       Claude
// @match        https://ai-bot.cn/*
// @grant        none
// @run-at       document-start
// ==/UserScript==

(function() {
    'use strict';

    // 强制启用右键菜单和选择功能
    function enableRightClickAndSelection() {
        // 移除所有事件监听器
        const events = ['contextmenu', 'copy', 'cut', 'paste', 'select', 'selectstart', 'mousedown', 'mouseup', 'keydown', 'keyup'];
        events.forEach(event => {
            window[`on${event}`] = null;
            document[`on${event}`] = null;
        });

        // 注入CSS
        const css = `
            * {
                -webkit-user-select: auto !important;
                -moz-user-select: auto !important;
                -ms-user-select: auto !important;
                user-select: auto !important;
                -webkit-touch-callout: auto !important;
            }
            *[unselectable="on"] {
                -webkit-user-select: auto !important;
                -moz-user-select: auto !important;
                -ms-user-select: auto !important;
                user-select: auto !important;
            }
        `;

        const style = document.createElement('style');
        style.innerHTML = css;
        (document.head || document.documentElement).appendChild(style);

        // 禁用常见的保护方法
        const disableProtection = function() {
            // 清除页面上的所有元素的事件监听器
            const elements = document.getElementsByTagName('*');
            for (let element of elements) {
                events.forEach(event => {
                    element[`on${event}`] = null;
                });

                // 移除可能存在的保护属性
                element.removeAttribute('oncontextmenu');
                element.removeAttribute('onselectstart');
                element.removeAttribute('oncopy');
                element.removeAttribute('oncut');
                element.removeAttribute('onpaste');
                element.removeAttribute('unselectable');

                // 设置样式
                element.style.cssText += '-webkit-user-select: auto !important; user-select: auto !important;';
            }
        };

        // 重写禁用函数
        const overrideMethods = function() {
            // 阻止事件监听器的添加
            const _addEventListener = EventTarget.prototype.addEventListener;
            EventTarget.prototype.addEventListener = function(type, listener, options) {
                if (events.includes(type)) {
                    return;
                }
                _addEventListener.call(this, type, listener, options);
            };

            // 禁用document.addEventListener
            document.addEventListener = function(type, listener, options) {
                if (events.includes(type)) {
                    return;
                }
                _addEventListener.call(document, type, listener, options);
            };

            // 覆盖一些常见的保护方法
            window.eval = function() { return null; };
            document.attachEvent = function() { return null; };
        };

        // 覆盖剪贴板事件
        document.addEventListener('copy', function(e) {
            e.stopPropagation();
        }, true);

        document.addEventListener('contextmenu', function(e) {
            e.stopPropagation();
            return true;
        }, true);

        // 执行解除保护
        disableProtection();
        overrideMethods();

        // 定期检查和移除新添加的保护
        setInterval(disableProtection, 1000);
    }

    // 在页面加载开始时执行
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', enableRightClickAndSelection);
    } else {
        enableRightClickAndSelection();
    }

    // 在页面完全加载后再次执行
    window.addEventListener('load', enableRightClickAndSelection);
})();
