package m01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test cases for method transform()
 * Expected:
 * 1. "" = <>
 * 2. "   " = <--->
 * 3. " disney Land  " = <-disney-Land-->
 * 4. "cSis 1410 " = <CSIS-1410->
 * 5. "Cisco and Basics" = <CSISco-and-Basics>
 * 6. "cs Disneyland  Best cs Class" = <CSIS-Disneyland--Best-cs-Class>
 * 7. "csister brother" = <CSISister-brother>
 * 8. "<cis Matterhorn>" = <<cis-Matterhorn>>
 * 9. "csis may have Cs issues CSIs with this one CIS" = <CSIS-may-have-Cs-issues-CSIs-with-this-one-CIS>
 * 10. "Splash Mountain" = <Splash-Mountain>
 * @author Russell
 *
 */
class Module01Test {

	@Test
	void blankWord() {
		assertEquals(Module01.transform(""),"<>","<>");
	}
	
	@Test
	void spacesOnly() {
		assertEquals(Module01.transform("   "),"<--->","<--->");
	}
	
	@Test
	void spacesAndWords() {
		assertEquals(Module01.transform(" disney Land  "),"<-disney-Land-->","<-disney-Land-->");
	}
	
	@Test
	void csisMultipleCases() {
		assertEquals(Module01.transform("cSis 1410 "),"<CSIS-1410->","<CSIS-1410->");
	}
	
	@Test
	void cisAndCsinSameSentence() {
		assertEquals(Module01.transform("Cisco and Basics"),"<CSISco-and-Basics>","<CSISco-and-Basics>");
	}
	
	@Test
	void csDisneyland() {
		assertEquals(Module01.transform("cs Disneyland  Best cs Class"),"<CSIS-Disneyland--Best-cs-Class>","<CSIS-Disneyland--Best-cs-Class>");
	}
	
	@Test
	void cSisterBrother() {
		assertEquals(Module01.transform("csister brother"),"<CSISter-brother>","<CSISter-brother>");
	}
	
	@Test
	void cisMatterhornAngleBrackets() {
		assertEquals(Module01.transform("<cis Matterhorn>"),"<<cis-Matterhorn>>","<<cis-Matterhorn>>");
	}
	
	@Test
	void csisMayHaveCsIssuesCsisWithThisOneCIS() {
		assertEquals(Module01.transform("csis may have Cs issues CSIs with this one CIS"),"<CSIS-may-have-Cs-issues-CSIs-with-this-one-CIS>",
				"<CSIS-may-have-Cs-issues-CSIs-with-this-one-CIS>");
	}
	
	@Test
	void splashMountain() {
		assertEquals(Module01.transform("Splash Mountain"),"<Splash-Mountain>","<Splash-Mountain>");
	}
}
