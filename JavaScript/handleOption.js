function handleOption(select,keyWord){
	if(isIE()){
		var children = select.children;
		for(var i = 0; i < children.length; i++){
			var nodeNow = children[i];
			if (nodeNow.nodeName == "OPTION"){
				if(nodeNow.text.search(keyWord) != -1){
					//show matched.
					nodeNow.hidden = false;
					}else{
						//hide not matched.
						nodeNow.hidden = true;
						var nodeNowBak = nodeNow.cloneNode(true);
						var span = document.createElement ("span");
						span.style.display = "none";
						span.appendChild(nodeNowBak);
						nodeNow.parentNode.replaceChild(span,nodeNow);
					}
				}else if(nodeNow.nodeName == "SPAN"){
					//you can use nodeNow.children[0] boldly, because the span node is created by me, so the span must has one option.
					var nodeOption = nodeNow.children[0];
					if(nodeOption.text.search(keyWord) != -1){
						//show matched.
						nodeOption.hidden = false;
						var optionBak = nodeOption.cloneNode(true);
						nodeNow.parentNode.replaceChild(optionBak,nodeNow);
					}else{
						//hide not matched.
						nodeOption.hidden = true;
						//this nodeOption's parentNode is span, the span's display value is none, so it's status is already hidden.
					}
				}
		}
	}else{
		var allOptions = select.options;
		//keyWord is not null
		if(keyWord){
			for(var i = 0; i < allOptions.length; i++){
				var optionNow = allOptions[i];
				if(optionNow.text.search(keyWord) != -1){
					//show matched.
					optionNow.hidden = false;
				}else{
					//hide not matched.
					optionNow.hidden = true;
				}
			}
		}else{
			//show all.
			for(var i = 0; i < select.options.length; i++){
				var optionNow = allOptions[i];
				optionNow.hidden = false;
			}
		}
	}
}
											

function isIE(){
	return (!!window.ActiveXObject) || ("ActiveXObject" in window);
}