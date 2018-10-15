package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class Auction_Manager extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a03191633179055612914806100326000396000f3006080604052600436106100565763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663571a26a0811461005b57806378bd7935146100915780639a1ed68a146100be575b600080fd5b34801561006757600080fd5b5061007b610076366004610355565b6100de565b6040516100889190610455565b60405180910390f35b34801561009d57600080fd5b506100b16100ac366004610355565b6100f9565b6040516100889190610441565b3480156100ca57600080fd5b506100b16100d936600461037b565b610114565b600160205260009081526040902054600160a060020a031681565b600090815260016020526040902054600160a060020a031690565b6000600260ff8516111561012757600080fd5b60ff841615156101bc57600054889088908690899089903390600160a060020a0316610151610306565b610161979695949392919061047e565b604051809103906000f08015801561017d573d6000803e3d6000fd5b506000898152600160205260409020805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055610292565b8360ff16600114156101ff5787878588888787336000809054906101000a9004600160a060020a03166101ed610316565b610161999897969594939291906104e6565b8360ff166002141561029257600054889088908690899089903390600160a060020a031661022b610326565b61023b979695949392919061047e565b604051809103906000f080158015610257573d6000803e3d6000fd5b506000898152600160205260409020805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790555b600088815260016020526040908190205490517ff1965c604ffa679ce37d35c0f3d5d769136a6b4757fac2769cb496e98d89b4f5916102dc918b91600160a060020a031690610463565b60405180910390a150505060009485525050600160205250506040902054600160a060020a031690565b604051610be68061058d83390190565b604051610b3c8061117383390190565b604051610c2c80611caf83390190565b60006103428235610578565b9392505050565b6000610342823561057b565b60006020828403121561036757600080fd5b60006103738484610336565b949350505050565b600080600080600080600060e0888a03121561039657600080fd5b60006103a28a8a610336565b97505060206103b38a828b01610336565b96505060406103c48a828b01610336565b95505060606103d58a828b01610336565b94505060806103e68a828b01610349565b93505060a06103f78a828b01610336565b92505060c06104088a828b01610336565b91505092959891949750929550565b6104208161056c565b82525050565b61042081610581565b61042081610578565b6104208161057b565b6020810161044f8284610417565b92915050565b6020810161044f8284610426565b60408101610471828561042f565b6103426020830184610426565b60e0810161048c828a61042f565b610499602083018961042f565b6104a66040830188610438565b6104b3606083018761042f565b6104c0608083018661042f565b6104cd60a0830185610417565b6104da60c0830184610417565b98975050505050505050565b61012081016104f5828c61042f565b610502602083018b61042f565b61050f604083018a610438565b61051c606083018961042f565b610529608083018861042f565b61053660a083018761042f565b61054360c083018661042f565b61055060e0830185610417565b61055e610100830184610417565b9a9950505050505050505050565b600160a060020a031690565b90565b60ff1690565b600061044f8261056c560060806040523480156200001157600080fd5b5060405160e08062000be68339810180604052620000339190810190620000c5565b60098054600160a060020a031916600160a060020a039384161790556000969096556001949094556002805460ff191660ff9490941693909317909255600355600455600a8054600160a860020a0319169290911691909117905562000185565b6000620000a2825162000170565b9392505050565b6000620000a282516200017c565b6000620000a282516200017f565b600080600080600080600060e0888a031215620000e157600080fd5b6000620000ef8a8a620000a9565b9750506020620001028a828b01620000a9565b9650506040620001158a828b01620000b7565b9550506060620001288a828b01620000a9565b94505060806200013b8a828b01620000a9565b93505060a06200014e8a828b0162000094565b92505060c0620001618a828b0162000094565b91505092959891949750929550565b600160a060020a031690565b90565b60ff1690565b610a5180620001956000396000f3006080604052600436106100825763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632d10fa2881146100875780632df4e21e146100bb5780633ccfd60b146100e85780636493a7ad146100f2578063939c8d0914610114578063d6dd52b214610134578063dcc8764614610147575b600080fd5b34801561009357600080fd5b5061009c610167565b6040516100b29a99989796959493929190610957565b60405180910390f35b3480156100c757600080fd5b506100db6100d6366004610784565b610282565b6040516100b29190610928565b6100f0610294565b005b3480156100fe57600080fd5b50610107610342565b6040516100b29190610917565b34801561012057600080fd5b506100f061012f3660046107c8565b6103d6565b6100f06101423660046107e6565b61052b565b34801561015357600080fd5b506100f06101623660046107aa565b610707565b60008060008060008060006060600080600054600154600260009054906101000a900460ff16600354600454600560009054906101000a9004600160a060020a03166006546007600960009054906101000a9004600160a060020a0316600a60149054906101000a900460ff1682805480602002602001604051908101604052809291908181526020016000905b8282101561025c5760008481526020908190206040805160a0810182526005860290920180548352600180820154848601526002820154928401929092526003810154606084015260040154600160a060020a0316608083015290835290920191016101f5565b505050509250995099509950995099509950995099509950995090919293949596979899565b60086020526000908152604090205481565b600954600090600160a060020a03163314156102af57600080fd5b336000908152600860205260409020541561033f575033600081815260086020526040808220805490839055905190929183156108fc02918491818181858888f19350505050158015610306573d6000803e3d6000fd5b507fac32cddf915f6ffcec025c2e4bf5c11baa7c91c5ae1534d75d19797b2dd45f55816040516103369190610928565b60405180910390a15b50565b60606007805480602002602001604051908101604052809291908181526020016000905b828210156103cd5760008481526020908190206040805160a0810182526005860290920180548352600180820154848601526002820154928401929092526003810154606084015260040154600160a060020a031660808301529083529092019101610366565b50505050905090565b60008042806003541015156103ea57600080fd5b600a5474010000000000000000000000000000000000000000900460ff16151561041357600080fd5b600954600160a060020a0316331461042a57600080fd5b600954600160a060020a03166000908152600860205260408120541161044f57600080fd5b600954600160a060020a03908116600090815260086020526040808220805490839055600a5491516064820489029182900397509095509216916108fc85150291859190818181858888f193505050501580156104b0573d6000803e3d6000fd5b50600954604051600160a060020a039091169084156108fc029085906000818181858888f193505050501580156104eb573d6000803e3d6000fd5b507f0df4854558964ae9ca4174e7f01d88c9e63fbfa0d31610147bfe9c891d88fbec838360405161051d92919061093c565b60405180910390a150505050565b808060035411151561053c57600080fd5b600954600160a060020a031633141561055457600080fd5b3460065466038d7ea4c68000011115151561056e57600080fd5b600654341161057c57600080fd5b6040805160a08101825285815260208082018681523483850181815260608501888152336080870181815260078054600181018255600091825298516005998a027fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68881019190915596517fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68988015593517fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68a87015591517fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68b86015590517fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68c9094018054600160a060020a0395861673ffffffffffffffffffffffffffffffffffffffff1991821617909155600680548854871685526008909752888420805490970190965594839055855490941690931790935560095416815282902055517f6a1558d1cdcac391f51b2ace2bafde892d43b6c9bf128b8c6cd23bf46c43e5cd9061051d908690610928565b428060035410151561071857600080fd5b50600a8054911515740100000000000000000000000000000000000000000274ff000000000000000000000000000000000000000019909216919091179055565b600061076582356109fd565b9392505050565b60006107658235610a09565b60006107658235610a0e565b60006020828403121561079657600080fd5b60006107a28484610759565b949350505050565b6000602082840312156107bc57600080fd5b60006107a2848461076c565b6000602082840312156107da57600080fd5b60006107a28484610778565b6000806000606084860312156107fb57600080fd5b60006108078686610778565b935050602061081886828701610778565b925050604061082986828701610778565b9150509250925092565b61083c816109fd565b82525050565b600061084d826109f9565b80845260208401935061085f836109f3565b60005b8281101561088f576108758683516108a2565b61087e826109f3565b60a096909601959150600101610862565b5093949350505050565b61083c81610a09565b805160a08301906108b38482610905565b5060208201516108c66020850182610905565b5060408201516108d96040850182610905565b5060608201516108ec6060850182610905565b5060808201516108ff6080850182610833565b50505050565b61083c81610a0e565b61083c81610a11565b602080825281016107658184610842565b602081016109368284610905565b92915050565b6040810161094a8285610905565b6107656020830184610905565b6101408101610966828d610905565b610973602083018c610905565b610980604083018b61090e565b61098d606083018a610905565b61099a6080830189610905565b6109a760a0830188610833565b6109b460c0830187610905565b81810360e08301526109c68186610842565b90506109d6610100830185610833565b6109e4610120830184610899565b9b9a5050505050505050505050565b60200190565b5190565b600160a060020a031690565b151590565b90565b60ff16905600a265627a7a72305820b02a13b6510b42eeca54de870c671bc12105db008c3990db816028ac0331ea5c6c6578706572696d656e74616cf5003760806040523480156200001157600080fd5b506040516101208062000b3c8339810180604052620000349190810190620000d3565b60098054600160a060020a031916600160a060020a039384161790556000989098556001969096556002805460ff191660ff9690961695909517909455600392909255600455600a8054600160a860020a0319169490931693909317909155600b91909155600c55620001bf565b6000620000b08251620001aa565b9392505050565b6000620000b08251620001b6565b6000620000b08251620001b9565b60008060008060008060008060006101208a8c031215620000f357600080fd5b6000620001018c8c620000b7565b9950506020620001148c828d01620000b7565b9850506040620001278c828d01620000c5565b97505060606200013a8c828d01620000b7565b96505060806200014d8c828d01620000b7565b95505060a0620001608c828d01620000b7565b94505060c0620001738c828d01620000b7565b93505060e0620001868c828d01620000a2565b9250506101006200019a8c828d01620000a2565b9150509295985092959850929598565b600160a060020a031690565b90565b60ff1690565b61096d80620001cf6000396000f3006080604052600436106100825763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632d10fa2881146100875780632df4e21e146100bb5780633ccfd60b146100e85780636493a7ad146100f2578063939c8d0914610114578063d6dd52b214610134578063dcc8764614610147575b600080fd5b34801561009357600080fd5b5061009c610167565b6040516100b29a99989796959493929190610873565b60405180910390f35b3480156100c757600080fd5b506100db6100d63660046106a0565b610282565b6040516100b29190610844565b6100f0610294565b005b3480156100fe57600080fd5b50610107610296565b6040516100b29190610833565b34801561012057600080fd5b506100f061012f3660046106e4565b61032a565b6100f0610142366004610702565b61047f565b34801561015357600080fd5b506100f06101623660046106c6565b610623565b60008060008060008060006060600080600054600154600260009054906101000a900460ff16600354600454600560009054906101000a9004600160a060020a03166006546007600960009054906101000a9004600160a060020a0316600a60149054906101000a900460ff1682805480602002602001604051908101604052809291908181526020016000905b8282101561025c5760008481526020908190206040805160a0810182526005860290920180548352600180820154848601526002820154928401929092526003810154606084015260040154600160a060020a0316608083015290835290920191016101f5565b505050509250995099509950995099509950995099509950995090919293949596979899565b60086020526000908152604090205481565b565b60606007805480602002602001604051908101604052809291908181526020016000905b828210156103215760008481526020908190206040805160a0810182526005860290920180548352600180820154848601526002820154928401929092526003810154606084015260040154600160a060020a0316608083015290835290920191016102ba565b50505050905090565b600080428060035410151561033e57600080fd5b600a5474010000000000000000000000000000000000000000900460ff16151561036757600080fd5b600954600160a060020a0316331461037e57600080fd5b600954600160a060020a0316600090815260086020526040812054116103a357600080fd5b600954600160a060020a03908116600090815260086020526040808220805490839055600a5491516064820489029182900397509095509216916108fc85150291859190818181858888f19350505050158015610404573d6000803e3d6000fd5b50600954604051600160a060020a039091169084156108fc029085906000818181858888f1935050505015801561043f573d6000803e3d6000fd5b507f0df4854558964ae9ca4174e7f01d88c9e63fbfa0d31610147bfe9c891d88fbec8383604051610471929190610858565b60405180910390a150505050565b808060035411151561049057600080fd5b600954600160a060020a03163314156104a857600080fd5b6040805160a08101825285815260208082018681523483850181815260608501888152336080870181815260078054600181018255600091825298516005998a027fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68881019190915596517fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68988015593517fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68a87015591517fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68b86015590517fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68c9094018054600160a060020a0395861673ffffffffffffffffffffffffffffffffffffffff19918216179091556006849055865416179094556003879055600954909116835260089091529082902055517f6a1558d1cdcac391f51b2ace2bafde892d43b6c9bf128b8c6cd23bf46c43e5cd90610471908690610844565b428060035410151561063457600080fd5b50600a8054911515740100000000000000000000000000000000000000000274ff000000000000000000000000000000000000000019909216919091179055565b60006106818235610919565b9392505050565b60006106818235610925565b6000610681823561092a565b6000602082840312156106b257600080fd5b60006106be8484610675565b949350505050565b6000602082840312156106d857600080fd5b60006106be8484610688565b6000602082840312156106f657600080fd5b60006106be8484610694565b60008060006060848603121561071757600080fd5b60006107238686610694565b935050602061073486828701610694565b925050604061074586828701610694565b9150509250925092565b61075881610919565b82525050565b600061076982610915565b80845260208401935061077b8361090f565b60005b828110156107ab576107918683516107be565b61079a8261090f565b60a09690960195915060010161077e565b5093949350505050565b61075881610925565b805160a08301906107cf8482610821565b5060208201516107e26020850182610821565b5060408201516107f56040850182610821565b5060608201516108086060850182610821565b50608082015161081b608085018261074f565b50505050565b6107588161092a565b6107588161092d565b60208082528101610681818461075e565b602081016108528284610821565b92915050565b604081016108668285610821565b6106816020830184610821565b6101408101610882828d610821565b61088f602083018c610821565b61089c604083018b61082a565b6108a9606083018a610821565b6108b66080830189610821565b6108c360a083018861074f565b6108d060c0830187610821565b81810360e08301526108e2818661075e565b90506108f261010083018561074f565b6109006101208301846107b5565b9b9a5050505050505050505050565b60200190565b5190565b600160a060020a031690565b151590565b90565b60ff16905600a265627a7a723058206c03b0a692b4a429fa2720c84acbc2a9ede9b7d223413a6bfad9c1f3cc2ff2ef6c6578706572696d656e74616cf5003760806040523480156200001157600080fd5b5060405160e08062000c2c8339810180604052620000339190810190620000c5565b60098054600160a060020a031916600160a060020a039384161790556000969096556001949094556002805460ff191660ff9490941693909317909255600355600455600a8054600160a860020a0319169290911691909117905562000185565b6000620000a2825162000170565b9392505050565b6000620000a282516200017c565b6000620000a282516200017f565b600080600080600080600060e0888a031215620000e157600080fd5b6000620000ef8a8a620000a9565b9750506020620001028a828b01620000a9565b9650506040620001158a828b01620000b7565b9550506060620001288a828b01620000a9565b94505060806200013b8a828b01620000a9565b93505060a06200014e8a828b0162000094565b92505060c0620001618a828b0162000094565b91505092959891949750929550565b600160a060020a031690565b90565b60ff1690565b610a9780620001956000396000f3006080604052600436106100825763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632d10fa2881146100875780632df4e21e146100bb5780633ccfd60b146100e85780636493a7ad146100f2578063939c8d0914610114578063d6dd52b214610134578063dcc8764614610147575b600080fd5b34801561009357600080fd5b5061009c610167565b6040516100b29a9998979695949392919061099d565b60405180910390f35b3480156100c757600080fd5b506100db6100d63660046107ca565b610282565b6040516100b2919061096e565b6100f0610294565b005b3480156100fe57600080fd5b50610107610353565b6040516100b2919061095d565b34801561012057600080fd5b506100f061012f36600461080e565b6103e7565b6100f061014236600461082c565b61053c565b34801561015357600080fd5b506100f06101623660046107f0565b61074d565b60008060008060008060006060600080600054600154600260009054906101000a900460ff16600354600454600560009054906101000a9004600160a060020a03166006546007600960009054906101000a9004600160a060020a0316600a60149054906101000a900460ff1682805480602002602001604051908101604052809291908181526020016000905b8282101561025c5760008481526020908190206040805160a0810182526005860290920180548352600180820154848601526002820154928401929092526003810154606084015260040154600160a060020a0316608083015290835290920191016101f5565b505050509250995099509950995099509950995099509950995090919293949596979899565b60086020526000908152604090205481565b600042806003541015156102a757600080fd5b600954600160a060020a03163314156102bf57600080fd5b336000908152600860205260409020541561034f5733600081815260086020526040808220805490839055905190945084156108fc0291859190818181858888f19350505050158015610316573d6000803e3d6000fd5b507fac32cddf915f6ffcec025c2e4bf5c11baa7c91c5ae1534d75d19797b2dd45f5582604051610346919061096e565b60405180910390a15b5050565b60606007805480602002602001604051908101604052809291908181526020016000905b828210156103de5760008481526020908190206040805160a0810182526005860290920180548352600180820154848601526002820154928401929092526003810154606084015260040154600160a060020a031660808301529083529092019101610377565b50505050905090565b60008042806003541015156103fb57600080fd5b600a5474010000000000000000000000000000000000000000900460ff16151561042457600080fd5b600954600160a060020a0316331461043b57600080fd5b600954600160a060020a03166000908152600860205260408120541161046057600080fd5b600954600160a060020a03908116600090815260086020526040808220805490839055600a5491516064820489029182900397509095509216916108fc85150291859190818181858888f193505050501580156104c1573d6000803e3d6000fd5b50600954604051600160a060020a039091169084156108fc029085906000818181858888f193505050501580156104fc573d6000803e3d6000fd5b507f0df4854558964ae9ca4174e7f01d88c9e63fbfa0d31610147bfe9c891d88fbec838360405161052e929190610982565b60405180910390a150505050565b808060035411151561054d57600080fd5b600954600160a060020a031633141561056557600080fd5b3460065466038d7ea4c68000011115151561057f57600080fd5b6040805160a08101825285815260208101858152349282018381526060830186815233608085019081526007805460018101825560009190915294517fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68860059096029586015592517fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68985015590517fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68a840155517fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68b830155517fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68c909101805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039092169190911790556006541015610708576006805460058054600160a060020a0390811660009081526008602052604080822080549095019094553494859055825473ffffffffffffffffffffffffffffffffffffffff19163317909255600954168152205561071e565b3360009081526008602052604090208054340190555b7f6a1558d1cdcac391f51b2ace2bafde892d43b6c9bf128b8c6cd23bf46c43e5cd8460405161052e919061096e565b428060035410151561075e57600080fd5b50600a8054911515740100000000000000000000000000000000000000000274ff000000000000000000000000000000000000000019909216919091179055565b60006107ab8235610a43565b9392505050565b60006107ab8235610a4f565b60006107ab8235610a54565b6000602082840312156107dc57600080fd5b60006107e8848461079f565b949350505050565b60006020828403121561080257600080fd5b60006107e884846107b2565b60006020828403121561082057600080fd5b60006107e884846107be565b60008060006060848603121561084157600080fd5b600061084d86866107be565b935050602061085e868287016107be565b925050604061086f868287016107be565b9150509250925092565b61088281610a43565b82525050565b600061089382610a3f565b8084526020840193506108a583610a39565b60005b828110156108d5576108bb8683516108e8565b6108c482610a39565b60a0969096019591506001016108a8565b5093949350505050565b61088281610a4f565b805160a08301906108f9848261094b565b50602082015161090c602085018261094b565b50604082015161091f604085018261094b565b506060820151610932606085018261094b565b5060808201516109456080850182610879565b50505050565b61088281610a54565b61088281610a57565b602080825281016107ab8184610888565b6020810161097c828461094b565b92915050565b60408101610990828561094b565b6107ab602083018461094b565b61014081016109ac828d61094b565b6109b9602083018c61094b565b6109c6604083018b610954565b6109d3606083018a61094b565b6109e0608083018961094b565b6109ed60a0830188610879565b6109fa60c083018761094b565b81810360e0830152610a0c8186610888565b9050610a1c610100830185610879565b610a2a6101208301846108df565b9b9a5050505050505050505050565b60200190565b5190565b600160a060020a031690565b151590565b90565b60ff16905600a265627a7a7230582078333a020d64c3c97a7cf80295c821fa1d10357679bdc4915d6d92710b1a5ab06c6578706572696d656e74616cf50037a265627a7a72305820937fdfca86e7c1c81fdddd84c2c5b423888839f8fe264321c5b894c1b7b20d876c6578706572696d656e74616cf50037";

    public static final String FUNC_AUCTIONS = "auctions";

    public static final String FUNC_GETAUCTION = "getAuction";

    public static final String FUNC_MAKEAUCTION = "makeAuction";

    public static final Event MAKEAUCTIONEVENT_EVENT = new Event("makeAuctionEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}), Arrays.<TypeReference<?>>asList());
    ;

    protected Auction_Manager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Auction_Manager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<String> auctions(BigInteger param0) {
        final Function function = new Function(FUNC_AUCTIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getAuction(BigInteger _auction_id) {
        final Function function = new Function(FUNC_GETAUCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_auction_id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> makeAuction(BigInteger _auction_id, BigInteger _seller_id, BigInteger _due_date, BigInteger _start_price, BigInteger _auction_type, BigInteger _down_price, BigInteger _down_term) {
        final Function function = new Function(
                FUNC_MAKEAUCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_auction_id), 
                new org.web3j.abi.datatypes.generated.Uint256(_seller_id), 
                new org.web3j.abi.datatypes.generated.Uint256(_due_date), 
                new org.web3j.abi.datatypes.generated.Uint256(_start_price), 
                new org.web3j.abi.datatypes.generated.Uint8(_auction_type), 
                new org.web3j.abi.datatypes.generated.Uint256(_down_price), 
                new org.web3j.abi.datatypes.generated.Uint256(_down_term)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Auction_Manager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Auction_Manager.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Auction_Manager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Auction_Manager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public List<MakeAuctionEventEventResponse> getMakeAuctionEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MAKEAUCTIONEVENT_EVENT, transactionReceipt);
        ArrayList<MakeAuctionEventEventResponse> responses = new ArrayList<MakeAuctionEventEventResponse>(valueList.size());
        
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MakeAuctionEventEventResponse typedResponse = new MakeAuctionEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.auction_id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.auction_address = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MakeAuctionEventEventResponse> makeAuctionEventEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MakeAuctionEventEventResponse>() {
            @Override
            public MakeAuctionEventEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MAKEAUCTIONEVENT_EVENT, log);
                MakeAuctionEventEventResponse typedResponse = new MakeAuctionEventEventResponse();
                typedResponse.log = log;
                typedResponse.auction_id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.auction_address = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<MakeAuctionEventEventResponse> makeAuctionEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MAKEAUCTIONEVENT_EVENT));
        return makeAuctionEventEventObservable(filter);
    }

    public static Auction_Manager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Auction_Manager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Auction_Manager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Auction_Manager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class MakeAuctionEventEventResponse {
        public Log log;

        public BigInteger auction_id;

        public String auction_address;
    }
}