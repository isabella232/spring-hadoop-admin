/*
 * Copyright 2011-2012 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.hadoop.admin.cli.commands;

import org.apache.commons.configuration.ConfigurationException;
import org.springframework.data.hadoop.admin.cli.util.Log;
import org.springframework.data.hadoop.admin.cli.util.PropertyUtil;
import org.springframework.roo.shell.CliCommand;
import org.springframework.roo.shell.CommandMarker;
import org.springframework.stereotype.Component;

/**
 * @author Jarred Li
 *
 */
@Component
public class InfoCommand implements CommandMarker {

	@CliCommand(value = "info", help = "list Spring Hadoop Admin CLI information")
	public void getCLIInfo() {
		try {
			String serviceUrl = PropertyUtil.getTargetURl();
			Log.show("    service url:    " + serviceUrl);			
			String dfsName = PropertyUtil.getDfsName();
			Log.show("    fs default name:    " + dfsName);
		} catch (ConfigurationException e) {
			Log.error("set target url failed. " + e.getMessage());
		}
	}

}